package org.example.repository;

import org.example.entity.Reader;

import java.util.List;

public interface ReaderRepository {
    String saveReader(Reader reader);
    Reader updateReader(Long id, Reader newReader);
    Reader getReaderByBookId(Long bookId);
    String deleteReaderById(Long id);
    List<Reader>getReadersByAuthorId(Long authorId);
}
