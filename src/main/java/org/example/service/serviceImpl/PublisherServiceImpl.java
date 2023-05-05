package org.example.service.serviceImpl;

import org.example.entity.Publisher;
import org.example.repository.repositoryImpl.PublisherRepositoryImpl;
import org.example.service.PublisherService;

import java.util.List;

public class PublisherServiceImpl implements PublisherService {
    PublisherRepositoryImpl repository = new PublisherRepositoryImpl();


    @Override
    public Publisher savePublisher(Publisher newPubLisher) {
        return repository.savePublisher(newPubLisher);
    }

    @Override
    public Publisher getPublisherById(Long id) {
        return repository.getPublisherById(id);
    }

    @Override
    public List<Publisher> getAllPublishersBySortedName() {
        return repository.getAllPublishersBySortedName();
    }

    @Override
    public String updatePublisher(Long id, Publisher newPublisher) {
        return repository.updatePublisher(id,newPublisher);
    }

    @Override
    public String deletePublisherByName(String name) {
        return repository.deletePublisherByName(name);
    }
}
