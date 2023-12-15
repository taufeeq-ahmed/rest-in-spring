package dev.spring.REST.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import dev.spring.REST.model.Content;
import dev.spring.REST.model.Status;
import dev.spring.REST.model.Type;
import jakarta.annotation.PostConstruct;

@Repository
public class ContentCollectionRepository {
    private final List<Content> content = new ArrayList<Content>();

    public ContentCollectionRepository() {

    }

    public List<Content> findAllContent() {
        return content;
    }

    public Optional<Content> findContentById(Integer id) {
        return content.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    @PostConstruct
    public void init() {
        Content c = new Content(
                23,
                "spring-boot-101",
                "My First app in spring boot",
                Status.IN_PROGRESS,
                Type.COURSE,
                LocalDateTime.now(),
                LocalDateTime.now());

        content.add(c);
    }
}
