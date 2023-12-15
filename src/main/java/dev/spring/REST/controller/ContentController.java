package dev.spring.REST.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.spring.REST.model.Content;
import dev.spring.REST.repository.ContentCollectionRepository;

@RestController
@RequestMapping("/api/content")
public class ContentController {
    private final ContentCollectionRepository repository;

    // when there is only one public constructor autowired is implcit @Autowired
    // means auto injection of dependency
    @Autowired
    public ContentController(ContentCollectionRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Content> list() {
        return repository.findAllContent();
    }
}
