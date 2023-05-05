package org.example.service;

import org.example.entity.Reader;

import java.util.List;

public interface ReaderService {
    String saveReader(Reader reader);
    Reader updateReader(Long id, Reader newReader);
    Reader getReaderByBookId(Long bookId);
    String deleteReaderById(Long id);
    List<Reader> getReadersByAuthorId(Long authorId);
}
