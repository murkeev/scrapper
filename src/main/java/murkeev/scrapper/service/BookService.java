package murkeev.scrapper.service;

import lombok.AllArgsConstructor;
import murkeev.scrapper.model.Book;
import murkeev.scrapper.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    private final ScrapperService scrapperService;

    public void scrapeAndSaveBooks(String url) {
        List<Book> books = scrapperService.scrape(url);
        bookRepository.saveAll(books);
    }
}
