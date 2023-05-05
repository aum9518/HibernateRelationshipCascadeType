package org.example.repository;

import org.example.entity.Author;

import java.util.List;

public interface AuthorRepository {
    Author saveAuthor(Author newAuthor);
    String updateAuthor(Long id, Author newAuthor);
    Author getAuthorById(long authorId);
    List<Author> getAuthorsByPublisherId(long publisherId);
    String deleteAuthorById(Long id);
    String assignAuthorToPublisher(Long authorId, Long publisherId);

}
