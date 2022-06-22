package pl.bookstore.app.data.generator;

import com.vaadin.exampledata.DataType;
import com.vaadin.exampledata.ExampleDataGenerator;
import com.vaadin.flow.spring.annotation.SpringComponent;
import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import pl.bookstore.app.data.entity.SampleBook;
import pl.bookstore.app.data.service.SampleBookRepository;

@SpringComponent
public class DataGenerator {

    @Bean
    public CommandLineRunner loadData(SampleBookRepository sampleBookRepository) {
        return args -> {
            Logger logger = LoggerFactory.getLogger(getClass());
            if (sampleBookRepository.count() != 0L) {
                logger.info("Using existing database");
                return;
            }
            int seed = 123;

            logger.info("Generating demo data");

            logger.info("... generating 100 Sample Book entities...");
            ExampleDataGenerator<SampleBook> sampleBookRepositoryGenerator = new ExampleDataGenerator<>(
                    SampleBook.class, LocalDateTime.of(2022, 6, 22, 0, 0, 0));
            sampleBookRepositoryGenerator.setData(SampleBook::setImage, DataType.BOOK_IMAGE_URL);
            sampleBookRepositoryGenerator.setData(SampleBook::setName, DataType.BOOK_TITLE);
            sampleBookRepositoryGenerator.setData(SampleBook::setAuthor, DataType.FULL_NAME);
            sampleBookRepositoryGenerator.setData(SampleBook::setPublicationDate, DataType.DATE_OF_BIRTH);
            sampleBookRepositoryGenerator.setData(SampleBook::setPages, DataType.NUMBER_UP_TO_1000);
            sampleBookRepositoryGenerator.setData(SampleBook::setIsbn, DataType.EAN13);
            sampleBookRepository.saveAll(sampleBookRepositoryGenerator.create(100, seed));

            logger.info("Generated demo data");
        };
    }

}