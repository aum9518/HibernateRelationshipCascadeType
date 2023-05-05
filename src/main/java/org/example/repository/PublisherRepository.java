package org.example.repository;

import org.example.entity.Publisher;

import java.util.List;

public interface PublisherRepository {
    Publisher savePublisher(Publisher newPublisher);
    Publisher getPublisherById(Long id);
    List<Publisher>getAllPublishersBySortedName();
    String updatePublisher(Long id, Publisher newPublisher);
    String deletePublisherByName(String name);



}
