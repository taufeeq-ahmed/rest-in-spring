package dev.spring.REST.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
    public List<Content> listContents() {
        return repository.findAllContent();
    }

    @GetMapping("/{id}")
    public Content getContent(@PathVariable Integer id) {
        return repository.findContentById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item Not Found"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postContent(@RequestBody Content content) {
        repository.save(content);
    }

    @PutMapping("/{id}")
    public void updateContent(@RequestBody Content content, @PathVariable Integer id) {
        if (!repository.isExisting(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item Not Found");
        }
        repository.updateContent(content, id);
    }
}
