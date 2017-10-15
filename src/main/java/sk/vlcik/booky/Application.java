package sk.vlcik.booky;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import sk.vlcik.booky.configuration.BookyConfiguration;

@SpringBootApplication(exclude = { HibernateJpaAutoConfiguration.class })
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(BookyConfiguration.class);
        app.run(args);
    }
}