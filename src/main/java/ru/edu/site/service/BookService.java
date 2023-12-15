package ru.edu.site.service;

import org.springframework.stereotype.Service;
import ru.edu.site.entity.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final List<Book> books = new ArrayList<>(Arrays.asList(
                    new Book(1, "title1", 1976),
                    new Book(2, "title2", 2003),
                    new Book(3, "title3", 1990),
                    new Book(4, "title4", 1992)));

    public List<Book> getAllBooks() {
        return books;
    }

    public Optional<Book> getBookById(int id) {
        return books.stream().filter(book -> book.getId() == id).findFirst();
    }

    public void addBook(Book book) {
        // делаем -1 так как ArrayList под капотом массив и индексация с 0
        books.set(book.getId() - 1, book);
    }
}
