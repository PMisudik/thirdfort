package sk.misudik.thirdfort;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sk.misudik.thirdfort.services.NotesService;
import sk.misudik.thirdfort.services.NotesServiceImpl;

@Configuration
public class AppConfiguration {

    @Bean
    public NotesService notesService() {
        return new NotesServiceImpl();
    }
}
