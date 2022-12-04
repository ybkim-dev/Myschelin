package project.myschelin.domain.store.dto;

import project.myschelin.domain.store.model.Category;
import project.myschelin.domain.store.model.Store;

public class StoreDashboardResponseDto {
    private final long id;
    private final String name;
    private final String description;
    private final String category;
    private final String imagePath;

    private StoreDashboardResponseDto(long id, String name, String description, Category category, String imagePath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category.getKoreanName();
        this.imagePath = imagePath;
    }

    public static StoreDashboardResponseDto from(Store store) {
        return new StoreDashboardResponseDto(store.getId(), store.getName(), store.getDescription(), store.getCategory(), store.getImagePath());
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
}
