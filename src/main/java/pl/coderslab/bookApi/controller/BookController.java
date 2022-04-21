package pl.coderslab.bookApi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.bookApi.Book;

@RestController
@RequestMapping("/books")
// Generuje konstruktor dla wszystkich pól z modyfikatorem final
public class BookController {
    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }


}
