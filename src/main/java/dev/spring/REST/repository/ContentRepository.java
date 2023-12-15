package dev.spring.REST.repository;

import org.springframework.data.repository.ListCrudRepository;

import dev.spring.REST.model.Content;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {

}
