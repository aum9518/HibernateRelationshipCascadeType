package org.example.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.entity.Publisher;
import org.example.repository.PublisherRepository;
import org.example.util.Util;

import java.util.List;

public class PublisherRepositoryImpl implements PublisherRepository {
    private final EntityManager en = Util.getEntityManager();
    @Override
    public Publisher savePublisher(Publisher newPublisher) {
        en.getTransaction().begin();
        en.persist(newPublisher);
        en.getTransaction().commit();
        en.close();
        return newPublisher;
    }

    @Override
    public Publisher getPublisherById(Long id) {
        en.getTransaction().begin();
        Publisher publisher = en.find(Publisher.class,id);
        en.getTransaction().commit();
        en.close();
        return publisher;
    }

    @Override
    public List<Publisher> getAllPublishersBySortedName() {
        en.getTransaction().begin();
        List<Publisher> publishers = en.createQuery("select p from Publisher p order by p.name asc",Publisher.class).getResultList();
        en.getTransaction().commit();
        en.close();
        return publishers;
    }

    @Override
    public String updatePublisher(Long id, Publisher newPublisher) {
        en.getTransaction().begin();
        Publisher publisher = en.find(Publisher.class,id);
        publisher.setName(newPublisher.getName());
        publisher.setAddress(newPublisher.getAddress());
        publisher.setAuthors(newPublisher.getAuthors());
        publisher.setBooks(newPublisher.getBooks());
        en.getTransaction().commit();
        en.close();
        return "Publisher with id "+id+" successfully updated...";
    }

    @Override
    public String deletePublisherByName(String name) {
        en.getTransaction().begin();
        Publisher publisher = (Publisher) en.createQuery("select p from Publisher p where p.name = ?1").setParameter(1,name).getSingleResult();
        en.remove(publisher);
        en.getTransaction().commit();
        en.close();

        return "Successfully deleted";
    }
}
