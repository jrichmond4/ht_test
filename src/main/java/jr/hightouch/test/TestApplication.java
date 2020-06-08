package jr.hightouch.test;

import jr.hightouch.test.data.model.Card;
import jr.hightouch.test.data.model.CardState;
import jr.hightouch.test.data.repository.CardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestApplication {
    private static final Logger log = LoggerFactory.getLogger(TestApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CardRepository repository) {
        return (args) -> {
            repository.save(new Card("Card 1", "test description", CardState.INPROGRESS));
            repository.save(new Card("Card 2", "test description 2", CardState.FINISHED));
            repository.save(new Card("Card 3", "test description 3", CardState.TODO));
        };
    }

}
