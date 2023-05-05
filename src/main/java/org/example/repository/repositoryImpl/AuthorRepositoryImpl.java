package org.example.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.entity.Author;
import org.example.entity.Publisher;
import org.example.repository.AuthorRepository;
import org.example.util.Util;

import java.util.List;

public class AuthorRepositoryImpl implements AuthorRepository {
    private final EntityManager e = Util.getEntityManager();

    @Override
    public Author saveAuthor(Author newAuthor) {
        e.getTransaction().begin();
//       e.createQuery("INSERT INTO  Author (firstName, lastName, email, dateOfBirth, country, gender)" +
//                        "VALUES (?1, ?2, ?3, ?4, ?5, ?6)", Author.class)
//                .setParameter(1,newAuthor.getFirstName())
//                .setParameter(2,newAuthor.getLastName())
//                .setParameter(3,newAuthor.getEmail())
//                .setParameter(4,newAuthor.getDateOfBirth())
//                .setParameter(5,newAuthor.getCountry())
//                .setParameter(6,newAuthor.getGender())
//                .executeUpdate();
        e.persist(newAuthor);
        e.getTransaction().commit();
        e.close();
        return newAuthor;
    }

    @Override
    public String updateAuthor(Long id, Author newAuthor) {
        e.getTransaction().begin();
        int w =  e.createQuery("update Author a set a.firstName = ?1, a.lastName=?2,a.email = ?3,a.dateOfBirth= ?4 ,a.country = ?5, a.gender = ?6 where a.id = ?7 ")
                .setParameter(1,newAuthor.getFirstName())
                .setParameter(2,newAuthor.getLastName())
                .setParameter(3,newAuthor.getEmail())
                .setParameter(4,newAuthor.getDateOfBirth())
                .setParameter(5,newAuthor.getCountry())
                .setParameter(6,newAuthor.getGender())
                .setParameter(7,id).executeUpdate();

        e.getTransaction().commit();
        e.close();
        return "Successfully updated...";
    }

    @Override
    public Author getAuthorById(long authorId) {
        e.getTransaction().begin();
        Author a = e.createQuery("select a from Author a left join fetch a.publishers  where a.id = :id",Author.class)
                .setParameter("id",authorId).getSingleResult();
//        Author a = e.find(Author.class, authorId);
        e.getTransaction().commit();
        e.close();
        return a;
    }

    @Override
    public List<Author> getAuthorsByPublisherId(long publisherId) {
        e.getTransaction().begin();
        List<Author> list = e.createQuery("select  a from Author a join a.publishers where a.id = :id")
                .setParameter("id",publisherId)
                .getResultList();
        e.getTransaction().commit();
        e.close();
        return list;
    }

    @Override
    public String deleteAuthorById(Long id) {
        e.getTransaction().begin();
//        Author a = e.createQuery("select a from Author a where a.id = :id",Author.class)
//                .setParameter("id",id)
//                .getSingleResult();
        Author a = e.find(Author.class,id);
        e.remove(a);
        e.getTransaction().commit();
        e.close();
        return "Successfully deleted...";
    }

    @Override
    public String assignAuthorToPublisher(Long authorId, Long publisherId) {
        e.getTransaction().begin();
        Author a = e.find(Author.class,authorId);
        Publisher p = e.find(Publisher.class,publisherId);
        a.getPublishers().add(p);
        p.getAuthors().add(a);
        e.getTransaction().commit();
        e.close();
        return "Successfully assigned...";
    }
}
