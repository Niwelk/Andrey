package monolit.book_assistant.service;

import monolit.book_assistant.dto.UserBookPutDto;
import org.springframework.transaction.annotation.Transactional;
import monolit.book_assistant.dto.UserBookCreateDto;
import monolit.book_assistant.dto.UserBookPatchDto;
import monolit.book_assistant.entity.Book;
import monolit.book_assistant.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class BookAssistantService {

    private static final Logger log = LoggerFactory.getLogger(BookAssistantService.class);
    private final BookRepository repository;

    BookAssistantService(BookRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void addBook(UserBookCreateDto bookDto) {
        log.info("[?] called addBook method");

        Book book = new Book();
        book.setName(bookDto.getName());
        book.setPrice(bookDto.getPrice());

        log.info("[+] SUCCESS addBook method WAS COMPLETED");

        repository.save(book);
    }

    @Transactional
    public List<Book> showAllBooks() {
        log.info("called showAllBooks method");

        return repository.findAll();
    }


    @Transactional(readOnly = true)
    public Optional<Book> findBookById(int id) {
        log.info("called findBookById method");

        return repository.findById(id);
    }

    /**
     *
     * @param id
     * @throws NoSuchElementException can throw
     */

    @Transactional
    public void deleteBookById(int id) {
        log.info("called deleteBookById method");

        Book book = findBookById(id).orElseThrow(() -> new NoSuchElementException("ID книги не найдено! "));

        repository.delete(book);

        log.info("[+] SUCCESS deleteBookById method WAS COMPLETED | Книга #" + id + " была удалена");
    }

    //для Put запроса оставить Book или создать отедельный UserBookPutDto?
    //а если пользователь вызовет put запрос но заменит не всё, получается что лучше бы он вызвал patch но я же не могу указывать пользователем до того как он запрос отправит
    @Transactional
    public void putBookById(int id, UserBookPutDto newBook) {
        log.info("[?] called putBookById method");
        Book bookFromDataBase = findBookById(id).orElseThrow(() -> new NoSuchElementException("ID книги не найдено!"));

        if (newBook.getName() == null || newBook.getPrice() == null) {
            throw new IllegalStateException("Недопустимое состояние объекта: измините все поля или отправьте запрос типа PATCH");
        }

        bookFromDataBase.setName(newBook.getName());
        bookFromDataBase.setPrice(newBook.getPrice());

        log.info("[SUCCESS] SUCCESS putBookById method WAS COMPLETED | Книга #" + id + " была обновлено");

        repository.save(bookFromDataBase);
    }

    @Transactional
    public void patchBookById(int id, UserBookPatchDto newBook) {
        log.info("[?] Called patchBookById");

        Book bookFromDataBase = findBookById(id).orElseThrow(() -> new NoSuchElementException("ID книги не найдено!"));

        if (newBook.getName() != null) {
            bookFromDataBase.setName(newBook.getName());
        }

        if (newBook.getPrice() != null) {
            bookFromDataBase.setPrice(newBook.getPrice());
        }

        log.info("[SUCCESS] SUCCESS patchBookById method WAS COMPLETED | Книга #" + id + " была обновлено");

        repository.save(bookFromDataBase);
    }
}
