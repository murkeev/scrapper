package murkeev.scrapper.controller;

import lombok.AllArgsConstructor;
import murkeev.scrapper.service.BookService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/scrapper")
@AllArgsConstructor
public class ScrapperController {
    private final BookService bookService;

    @GetMapping("/scrape")
    public ResponseEntity<Void> scrape(@RequestParam String url) {
        bookService.scrapeAndSaveBooks(url);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }
}
