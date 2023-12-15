package dev.spring.REST.repository;

import org.springframework.data.repository.ListCrudRepository;

import dev.spring.REST.model.Content;
import java.util.List;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {
    List<Content> findAllByTitleContains(String query);

    List<Content> findAllByDescContains(String query);
}
