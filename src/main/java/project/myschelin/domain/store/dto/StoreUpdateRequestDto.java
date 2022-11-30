package project.myschelin.domain.store.dto;

import project.myschelin.domain.store.model.Category;
import project.myschelin.domain.store.model.Store;

public record StoreUpdateRequestDto(Long id, String name, String description, Category category) {
    public Store toStore() {
        return new Store(id, name, description, category);
    }
}
