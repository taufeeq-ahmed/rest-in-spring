package dev.spring.REST.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import dev.spring.REST.model.Content;
import dev.spring.REST.model.Status;
import dev.spring.REST.model.Type;
import dev.spring.REST.repository.ContentRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final ContentRepository repository;

    @Autowired
    public DataLoader(ContentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Content> contentList = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            Content c = new Content(
                    null,
                    "spring-boot-101__" + i,
                    "My First app in spring boot__" + i,
                    Status.IN_PROGRESS,
                    Type.COURSE,
                    LocalDateTime.now(),
                    LocalDateTime.now());
            contentList.add(c);
        }

        repository.saveAll(contentList);
    }
}
