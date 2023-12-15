package dev.spring.REST.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import dev.spring.REST.model.Content;
import java.util.List;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {
    List<Content> findAllByTitleContains(String query);

    List<Content> findAllByDescContains(String query);

    @Query("""
            SELECT * FROM content
            WHERE status = :status
            """)
    List<Content> listByStatus(@Param("status") String query);
}
