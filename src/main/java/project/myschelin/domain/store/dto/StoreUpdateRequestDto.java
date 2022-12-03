package project.myschelin.domain.store.dto;

import project.myschelin.domain.store.model.Category;
import project.myschelin.domain.store.model.Store;

public record StoreUpdateRequestDto(String name, String description, String category) {
    public Store toStore(long id) {
        return new Store(id, name, description, Category.findByKoreanName(category));
    }
}
