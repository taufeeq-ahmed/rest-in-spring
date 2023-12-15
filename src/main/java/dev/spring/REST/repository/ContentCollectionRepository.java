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
    private final List<Content> contentList = new ArrayList<Content>();

    public ContentCollectionRepository() {

    }

    public List<Content> findAllContent() {
        return contentList;
    }

    public Optional<Content> findContentById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public void save(Content content) {
        contentList.add(content);
    }

    public Optional<Content> updateContent(Content content, Integer id) {
        contentList.removeIf(c -> c.id().equals(id));
        save(content);
        return contentList.stream().filter(c -> c.id().equals(content.id())).findFirst();
    }

    public void deleteContent(Integer id) {
        contentList.removeIf(c -> c.id().equals(id));
    }

    public boolean isExisting(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).count() == 1;
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

        contentList.add(c);
    }
}
