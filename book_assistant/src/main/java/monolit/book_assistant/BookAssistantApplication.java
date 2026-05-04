package monolit.book_assistant;

import monolit.book_assistant.service.BookAssistantService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BookAssistantApplication {

	public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BookAssistantApplication.class, args);

        BookAssistantService service = context.getBean(BookAssistantService.class, args);
	}

}
