package dev.spring.REST.model;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record Content(
                Integer id,
                @NotEmpty @NotBlank String title,
                @NotEmpty @NotBlank String desc,
                @NotEmpty Status status, Type contentType,
                @NotEmpty LocalDateTime dateCreated,
                @NotEmpty LocalDateTime dateUpdated) {
}
