package lt.viko.eif.esemasko.Assessment_Task_3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class that populates the database on application startup.
 */
@Configuration
public class LoadDatabase {
    /**
     * Logger instance used for logging events for this class.
     */
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    /**
     * Command line runner bean that initializes the database with data.
     *
     * @param repository the movie repository
     * @return a CommandLineRunner
     */
    @Bean
    CommandLineRunner initDatabase(MovieRepository repository) {

        return args -> {
        };

    }

}
