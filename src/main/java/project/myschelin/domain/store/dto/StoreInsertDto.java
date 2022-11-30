package project.myschelin.domain.store.dto;

import project.myschelin.domain.store.model.Category;

public record StoreInsertDto(String name, String description, Category category, String imagePath) {
}
