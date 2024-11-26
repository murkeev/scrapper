package murkeev.scrapper.service.impl;

import murkeev.scrapper.exceptions.ScrapException;
import murkeev.scrapper.model.Book;
import murkeev.scrapper.service.ScrapperService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScrapperServiceImpl implements ScrapperService {

    public List<Book> scrapBooks(String url) {
        List<Book> books = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url).get();
            Elements items = document.select(".product_pod");

            for (Element item : items) {
                Book book = new Book();
                book.setTitle(item.select("h3 > a").attr("title"));
                book.setPrice(item.select(".price_color").text());
                book.setAvailability(item.select(".instock").text());
                String rating = item.select(".star-rating").attr("class")
                        .replace("star-rating ", "");
                book.setRating(rating);
                books.add(book);
            }

            return books;
        } catch (IOException e) {
            throw new ScrapException("Something went wrong...");
        }
    }
}