package org.example.service.serviceImpl;

import org.example.entity.Reader;
import org.example.repository.repositoryImpl.ReaderRepositoryImpl;
import org.example.service.ReaderService;

import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    ReaderRepositoryImpl repository  = new ReaderRepositoryImpl();
    @Override
    public String saveReader(Reader reader) {
        return repository.saveReader(reader);
    }

    @Override
    public Reader updateReader(Long id, Reader newReader) {
        return repository.updateReader(id,newReader);
    }

    @Override
    public Reader getReaderByBookId(Long bookId) {
        return repository.getReaderByBookId(bookId);
    }

    @Override
    public String deleteReaderById(Long id) {
        return repository.deleteReaderById(id);
    }

    @Override
    public List<Reader> getReadersByAuthorId(Long authorId) {
        return repository.getReadersByAuthorId(authorId);
    }
}
