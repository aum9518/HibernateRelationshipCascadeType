package org.example.service;

import org.example.entity.Book;
import org.example.entity.Publisher;

import java.util.Map;

public interface BookService {
    String saveBook(Book book);
    Book updateBookAuthor(Long authorId, Long bookId);
    Map<Book, Publisher> getBookAndPublisherByBookId(Long bookId);
    String deleteBookByAuthorId(Long authorId);
}
