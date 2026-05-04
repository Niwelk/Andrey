package monolit.book_assistant.controller;

import jakarta.validation.Valid;
import monolit.book_assistant.dto.UserBookCreateDto;
import monolit.book_assistant.dto.UserBookPatchDto;
import monolit.book_assistant.dto.UserBookPutDto;
import monolit.book_assistant.service.BookAssistantService;
import monolit.book_assistant.entity.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class BookAssistantController {

    private static final Logger log = LoggerFactory.getLogger(BookAssistantController.class);
    private final BookAssistantService assistantService;

    BookAssistantController(BookAssistantService assistantService) {
        this.assistantService = assistantService;
    }

    /**
     * метод чтобы НАЙТИ КНИГУ по ID
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable Integer id) {
        log.info("Called findBookByBook");
        return assistantService.findBookById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(504).build());
    }

    /**
     * метод чтобы ПОКАЗАТЬ ВСЕ КНИГИ
     *
     * @return
     */
    @GetMapping()
    public ResponseEntity<List<Book>> showAllContent() {
        log.info("Called showAllContent");
        return ResponseEntity.status(200).body(assistantService.showAllBooks());
    }

    /**
     * метод чтобы СОЗДАТЬ (положить) книгу в бд
     *
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<Void> createBook(@Valid @RequestBody UserBookCreateDto book) {
        log.info("Called createBook");
        assistantService.addBook(book);
        return ResponseEntity.status(201).build();
    }

    /**
     * метод чтобы ПОЛНОСТЬЮ ОБНОВИТЬ существующие книги
     *
     * @return
     */
    @PutMapping("/{id}/put")
    public ResponseEntity<String> updateBookById(@PathVariable Integer id, @Valid @RequestBody UserBookPutDto bookPutDto) {
        log.info("called updateBookById");
        assistantService.putBookById(id, bookPutDto);

        return ResponseEntity.status(202).body("Книга: " + id + " была успешна изменена");
    }

    /**
     * метод чтобы ЧАСТИЧНО ОБНОВИТЬ существующие книги
     *
     * @return
     */
    @PatchMapping("/{id}/patch")
    public ResponseEntity<String> patchBookById(@PathVariable int id, @Valid @RequestBody UserBookPatchDto bookPatchDto) {
        log.info("called patchBookById");

        assistantService.patchBookById(id, bookPatchDto);
        return ResponseEntity.status(202).body("Книга: " + id + " была успешна изменена");
    }

    /**
     * метод чтобы ПОКАЗАТЬ ВСЕ КНИГИ
     *
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable Integer id) {
        log.info("Called deleteBookById");
        assistantService.deleteBookById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
