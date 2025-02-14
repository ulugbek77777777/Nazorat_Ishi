package com.company;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/books")
public class BookController {
    private List<Book> books = new ArrayList<>();

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        books.add(book);
        return book;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book updatedBook) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                books.set(i, updatedBook);
                return updatedBook;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                books.remove(i);
                return "Book deleted successfully";
            }
        }
        return "Book not found";
    }

    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam(required = false) String title, @RequestParam(required = false) String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if ((title != null && book.getTitle().equalsIgnoreCase(title)) ||
                    (author != null && book.getAuthor().equalsIgnoreCase(author))) {
                result.add(book);
            }
        }
        return result;
    }
}