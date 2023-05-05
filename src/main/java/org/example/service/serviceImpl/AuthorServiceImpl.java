package org.example.service.serviceImpl;

import org.example.entity.Author;
import org.example.repository.repositoryImpl.AuthorRepositoryImpl;
import org.example.service.AuthorService;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {
    AuthorRepositoryImpl repository = new AuthorRepositoryImpl();
    @Override
    public Author saveAuthor(Author newAuthor) {
        return repository.saveAuthor(newAuthor);
    }

    @Override
    public String updateAuthor(Long id, Author newAuthor) {
        return repository.updateAuthor(id,newAuthor);
    }

    @Override
    public Author getAuthorById(long authorId) {
        return repository.getAuthorById(authorId);
    }

    @Override
    public List<Author> getAuthorsByPublisherId(long publisherId) {
        return repository.getAuthorsByPublisherId(publisherId);
    }

    @Override
    public String deleteAuthorById(Long id) {
        return repository.deleteAuthorById(id);
    }

    @Override
    public String assignAuthorToPublisher(Long authorId, Long publisherId) {
        return repository.assignAuthorToPublisher(authorId, publisherId);
    }
}
