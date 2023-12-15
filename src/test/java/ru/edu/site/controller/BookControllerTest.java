package ru.edu.site.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.edu.site.config.WebApplicationConfig;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebApplicationConfig.class})
class BookControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void books() throws Exception {
        mockMvc.perform(get("/books")
                        .contentType("text/html"))
                .andExpect(status().isOk())
                .andExpect(view().name("books/books-list"))
                .andExpect(model().attributeExists("books"))
                .andDo(print()); // для дебага
    }

    @Test
    void edit() throws Exception{
        mockMvc.perform(get("/book/edit/1")
                        .contentType("text/html"))
                .andExpect(status().isOk())
                .andExpect(view().name("books/book-edit"))
                .andExpect(model().attributeExists("book"))
                .andDo(print()); // для дебага
    }

    @Test
    void updateBookSuccess() throws Exception{
        mockMvc.perform(post("/book/update")
                        .contentType("text/html")
                        .param("id", "1")
                        .param("title", "test")
                        .param("year", "1990"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/books"))
                .andDo(print()); // для дебага
    }

    @Test
    void updateBookTitleError() throws Exception{
        mockMvc.perform(post("/book/update")
                        .contentType("text/html")
                        .param("id", "1")
                        .param("title", "0")
                        .param("year", "1990"))
                .andExpect(status().isOk())
                .andExpect(view().name("books/book-edit"))
                .andExpect(model().attributeHasFieldErrorCode("book", "title", "Size"))
                .andDo(print()); // для дебага
    }
}