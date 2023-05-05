package org.example.service;

import org.example.entity.Publisher;

import java.util.List;

public interface PublisherService {
    Publisher savePublisher(Publisher newPubLisher);
    Publisher getPublisherById(Long id);
    List<Publisher> getAllPublishersBySortedName();
    String updatePublisher(Long id, Publisher newPublisher);
    String deletePublisherByName(String name);

}
