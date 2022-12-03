package project.myschelin.domain.store.dto;

import org.springframework.web.multipart.MultipartFile;
import project.myschelin.domain.store.model.Category;
import project.myschelin.domain.store.model.Store;


public final class StoreAdminInsertRequestDto {
    private final String name;
    private final String description;
    private final String category;
    private final MultipartFile imageFile;
    private String imagePath;

    public StoreAdminInsertRequestDto(String name, String description, String category, MultipartFile imageFile) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.imageFile = imageFile;
    }

    public Store toStore() {
        return new Store(name, description, Category.findByKoreanName(category), imagePath);
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String category() {
        return category;
    }

    public MultipartFile getImageFile() {
        return imageFile;
    }
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
