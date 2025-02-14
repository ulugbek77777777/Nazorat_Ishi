package com.company;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Book getBookById(int id) {
        return books.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
    }

    public void updateBook(int id, Book book) {
        deleteBook(id);
        books.add(book);
    }

    public void deleteBook(int id) {
        books.removeIf(b -> b.getId() == id);
    }

    public List<Book> searchBooks(String title, String author) {
        return books.stream().filter(book -> book.getTitle().equals(title) && book.getAuthor().equals(author)).collect(Collectors.toList());
    }
}
