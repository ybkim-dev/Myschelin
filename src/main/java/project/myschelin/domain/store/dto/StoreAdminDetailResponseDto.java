package project.myschelin.domain.store.dto;

import project.myschelin.domain.store.model.Category;
import project.myschelin.domain.store.model.Store;

import java.time.LocalDateTime;

public class StoreAdminDetailResponseDto {
    private final long id;
    private final String name;
    private final String description;
    private final String category;
    private final String imagePath;
    private final LocalDateTime createdAt;

    private StoreAdminDetailResponseDto(long id, String name, String description, Category category, String imagePath, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category.getKoreanName();
        this.imagePath = imagePath;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getImagePath() {
        return imagePath;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public static StoreAdminDetailResponseDto from(Store store) {
        return new StoreAdminDetailResponseDto(store.getId(), store.getName(), store.getDescription(), store.getCategory(), store.getImagePath(), store.getCreatedAt());
    }
}
