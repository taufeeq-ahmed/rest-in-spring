package dev.spring.REST.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import dev.spring.REST.model.Content;

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
}
