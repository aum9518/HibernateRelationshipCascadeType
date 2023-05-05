package org.example.service.serviceImpl;

import org.example.entity.Book;
import org.example.entity.Publisher;
import org.example.repository.repositoryImpl.BookRepositoryImpl;
import org.example.service.BookService;

import java.util.Map;

public class BookServiceImpl implements BookService {
    BookRepositoryImpl repository = new BookRepositoryImpl();
    @Override
    public String saveBook(Book book) {
        return repository.saveBook(book);
    }

    @Override
    public Book updateBookAuthor(Long authorId, Long bookId) {
        return repository.updateBookAuthor(authorId,bookId);
    }

    @Override
    public Map<Book, Publisher> getBookAndPublisherByBookId(Long bookId) {
        return repository.getBookAndPublisherByBookId(bookId);
    }

    @Override
    public String deleteBookByAuthorId(Long authorId) {
        return repository.deleteBookByAuthorId(authorId);
    }
}
