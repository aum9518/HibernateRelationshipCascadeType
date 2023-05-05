package org.example.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import org.example.entity.Book;
import org.example.entity.Reader;
import org.example.repository.ReaderRepository;
import org.example.util.Util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ReaderRepositoryImpl implements ReaderRepository {
    private final EntityManager e = Util.getEntityManager();
    @Override
    public String saveReader(Reader reader) {
        e.getTransaction().begin();
            e.persist(reader);
            e.merge(reader);
            e.getTransaction().commit();
            e.close();
        return "Successfully saved...";
    }

    @Override
    public Reader updateReader(Long id, Reader newReader) {
        e.getTransaction().begin();
        Reader reader = e.find(Reader.class, id);
        reader.setName(newReader.getName());
        reader.setEmail(newReader.getEmail());
        reader.setAge(newReader.getAge());
        e.getTransaction().commit();
        e.close();
        return reader;
    }

    @Override
    public Reader getReaderByBookId(Long bookId) {
        e.getTransaction().begin();
        Reader reader = e.createQuery("select r from Reader r join r.book b where b.id = :id",Reader.class)
                .setParameter("id",bookId).getSingleResult();

        e.getTransaction().commit();
        e.close();
        return reader;
    }

    @Override
    public String deleteReaderById(Long id) {
        e.getTransaction().begin();
        Reader reader = e.find(Reader.class, id);
        e.remove(reader);
        e.getTransaction().commit();
        e.close();
        return "Successfully deleted...";
    }

    @Override
    public List<Reader> getReadersByAuthorId(Long authorId) {
      /*  List<Reader>readers = new ArrayList<>();
        e.getTransaction().begin();
        List<Book>books = e.createQuery("select b from Book b where b.author.id = :authorId",Book.class)
                .setParameter("authorId",authorId).getResultList();
        for (Book book:books) {
            Reader reader = e.createQuery("select r from Reader r where r.book.id = :bookId",Reader.class)
                    .setParameter("bookId",book.getId())
                    .getSingleResult();
            readers.add(reader);
            e.getTransaction().commit();
            e.close();
        }*/
        List<Reader>readers = new ArrayList<>();
        e.getTransaction().begin();
        List<Book> books = e.createQuery("select b from Book b where b.author.id = :authorId",Book.class)
                .setParameter("authorId",authorId).getResultList();
        books.forEach(System.out::println);
        for (Book b:books ) {
            readers.add(b.getReader());
            e.getTransaction().commit();
            e.close();
        }

        return readers;
    }
}
