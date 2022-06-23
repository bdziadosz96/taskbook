package pl.bookstore.app.data.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.bookstore.app.data.entity.SampleBook;

@Service
public class SampleBookService {

    private final SampleBookRepository repository;

    @Autowired
    public SampleBookService(SampleBookRepository repository) {
        this.repository = repository;
    }

    public Optional<SampleBook> get(UUID id) {
        return repository.findById(id);
    }

    public SampleBook update(SampleBook entity) {
        return repository.save(entity);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public Page<SampleBook> list(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public int count() {
        return (int) repository.count();
    }

    public List<SampleBook> findAll() {
        return repository.findAll();
    }
}
