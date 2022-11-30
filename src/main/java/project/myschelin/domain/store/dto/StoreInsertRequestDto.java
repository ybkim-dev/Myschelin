package project.myschelin.domain.store.dto;

import project.myschelin.domain.store.model.Category;
import project.myschelin.domain.store.model.Store;

public record StoreInsertRequestDto(String name, String description, String category, String imagePath) {

    public Store toStore() {
        return new Store(name, description, Category.findByKoreanName(category), imagePath);
    }
}
