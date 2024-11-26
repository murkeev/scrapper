package murkeev.scrapper.service;

import murkeev.scrapper.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ScrapperService {

    List<Book> scrapBooks(String url);
}