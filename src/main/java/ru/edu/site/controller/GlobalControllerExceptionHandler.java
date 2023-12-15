package ru.edu.site.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public String defaultErrorHandler(HttpServletRequest req, Exception e, Model model) {
        model.addAttribute("url", req.getRequestURL());
        model.addAttribute("message", e.getMessage());
        return "error/404";
    }
}
