package ru.edu.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.edu.site.entity.Cart;



@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("cart", new Cart(10, 20));
        return "index";
    }

}
