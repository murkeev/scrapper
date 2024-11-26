package murkeev.scrapper.controller;

import lombok.AllArgsConstructor;
import murkeev.scrapper.model.Book;
import murkeev.scrapper.service.impl.BookServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/books")
@AllArgsConstructor
public class BookController {

    private final BookServiceImpl bookService;

    @GetMapping
    public Page<Book> getAll(@RequestParam(value = "page_number") int pageNumber,
                             @RequestParam(value = "page_size") int pageSize) {
        return bookService.findAllBooks(PageRequest.of(pageNumber, pageSize));
    }

    @GetMapping("/get-by-title")
    public Page<Book> getByTitle(@RequestParam String title,
                                 @RequestParam(value = "page_number") int pageNumber,
                                 @RequestParam(value = "page_size") int pageSize) {
        return bookService.findByTitle(title, PageRequest.of(pageNumber, pageSize));
    }

    @GetMapping("/book/{id}")
    public Book getById(@PathVariable Long id) {
        return bookService.findBookById(id);
    }

    @DeleteMapping("/delete-by-id/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        bookService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete-all")
    public ResponseEntity<Void> deleteAll() {
        bookService.deleteAllBooks();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}