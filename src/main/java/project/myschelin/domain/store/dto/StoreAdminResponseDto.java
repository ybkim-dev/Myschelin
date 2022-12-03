package project.myschelin.domain.store.dto;

import project.myschelin.domain.store.model.Category;
import project.myschelin.domain.store.model.Store;

public class StoreAdminResponseDto {
    private final long id;
    private final String name;
    private final String category;

    private StoreAdminResponseDto(long id, String name, Category category) {
        this.id = id;
        this.name = name;
        this.category = category.getKoreanName();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public static StoreAdminResponseDto from(Store store) {
        return new StoreAdminResponseDto(store.getId(), store.getName(), store.getCategory());
    }
}
