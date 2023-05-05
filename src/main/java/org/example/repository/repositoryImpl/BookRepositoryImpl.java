package org.example.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import org.example.entity.Author;
import org.example.entity.Book;
import org.example.entity.Publisher;
import org.example.repository.BookRepository;
import org.example.util.Util;

import java.util.HashMap;
import java.util.Map;

public class BookRepositoryImpl implements BookRepository {
    private final EntityManager e = Util.getEntityManager();
    @Override
    public String saveBook(Book book) {
        e.getTransaction().begin();
         e.persist(book);
         e.getTransaction().commit();
         e.close();
        return "Successfully saved...";
    }

    @Override
    public Book updateBookAuthor(Long authorId, Long bookId) {
        e.getTransaction().begin();
        Author author = e.find(Author.class, authorId);
        Book book = e.find(Book.class, bookId);
        book.setAuthor(author);
        e.getTransaction().commit();
        e.close();
        return book;
    }

    @Override
    public Map<Book, Publisher> getBookAndPublisherByBookId(Long bookId) {
        Map<Book,Publisher> map = new HashMap<>();
        e.getTransaction().begin();
//        Book book = e.find(Book.class, bookId);
        Book book = e.createQuery("select b from Book b left join fetch b.publisher where b.id = :id", Book.class)
                .setParameter("id", bookId)
                .getSingleResult();
        Publisher id = book.getPublisher();
        map.put(book,id);
        e.getTransaction().commit();
        e.close();

        return map;
    }

    @Override
    public String deleteBookByAuthorId(Long authorId) {
        e.getTransaction().begin();
Book book = e.createQuery("select b from Book b join b.author a where a.id = :id", Book.class)
        .setParameter("id",authorId).getSingleResult();
        e.remove(book);
        e.getTransaction().commit();
        e.close();
        return "Successfully deleted...";
    }
}
