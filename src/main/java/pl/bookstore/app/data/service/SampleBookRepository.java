package pl.bookstore.app.data.service;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.bookstore.app.data.entity.SampleBook;

public interface SampleBookRepository extends JpaRepository<SampleBook, UUID> {

}