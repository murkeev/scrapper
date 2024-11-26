package murkeev.scrapper.controller;

import lombok.AllArgsConstructor;
import murkeev.scrapper.service.impl.BookServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/scrapper")
@AllArgsConstructor
public class ScrapperController {
    private final BookServiceImpl bookServiceImpl;

    @GetMapping("/scrape")
    public ResponseEntity<Void> scrape(@RequestParam String url,
                                       @RequestParam(value = "page", required = false) Integer pageNumber) {
        bookServiceImpl.scrapeAndSaveBooks(url, pageNumber);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}