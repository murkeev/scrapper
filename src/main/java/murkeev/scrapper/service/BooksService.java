package murkeev.scrapper.service;

import murkeev.scrapper.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface BooksService {

    void scrapeAndSaveBooks(String url, Integer pageNumber);

    Page<Book> findAllBooks(Pageable pageable);

    Page<Book> findByTitle(String title, Pageable pageable);

    Book findBookById(Long id);

    void deleteAllBooks();

    void deleteById(Long id);
}