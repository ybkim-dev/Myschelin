package project.myschelin.domain.store.dto;

import project.myschelin.domain.store.model.Category;

public record StoreUpdateDto(Long id, String name, String description, Category category) {
}
