package dev.spring.REST.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record Content(
                @Id Integer id,
                @NotEmpty @NotBlank String title,
                @NotEmpty @NotBlank String desc,
                @NotEmpty Status status,
                Type contentType,
                @NotEmpty LocalDateTime dateCreated,
                @NotEmpty LocalDateTime dateUpdated) {
}
