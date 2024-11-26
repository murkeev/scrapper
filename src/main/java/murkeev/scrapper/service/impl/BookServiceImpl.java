package murkeev.scrapper.service.impl;

import lombok.AllArgsConstructor;
import murkeev.scrapper.exceptions.EntityNotFoundException;
import murkeev.scrapper.model.Book;
import murkeev.scrapper.repository.BookRepository;
import murkeev.scrapper.service.BooksService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BooksService {
    private final BookRepository bookRepository;
    private final ScrapperServiceImpl scrapperServiceImpl;

    public void scrapeAndSaveBooks(String url, Integer pageNumber) {
        int page = (pageNumber != null) ? pageNumber : 1;
        String fullUrl = url.endsWith("/") ? url + "page-" + page : url + "/page-" + page;
        List<Book> books = scrapperServiceImpl.scrapBooks(fullUrl + ".html");
        bookRepository.saveAll(books);
    }

    @Override
    public Page<Book> findAllBooks(Pageable pageable) {
        Page<Book> booksPage = bookRepository.findAll(pageable);

        if (booksPage.isEmpty()) {
            throw new EntityNotFoundException("Books not found");
        }
        return booksPage;
    }

    @Override
    public Page<Book> findByTitle(String title, Pageable pageable) {
        Page<Book> booksPage = bookRepository.findAll(pageable);

        if (booksPage.isEmpty()) {
            throw new EntityNotFoundException("Books not found");
        }
        return booksPage;
    }

    @Override
    public Book findBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Book not found"));
    }

    @Override
    public void deleteAllBooks() {
        try {
            bookRepository.deleteAll();
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("Books not found");
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            bookRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("Book not found");
        }
    }
}