package project.myschelin.domain.store.model;

import java.time.LocalDateTime;

public class Store {
    private long id;
    private String name;
    private String description;
    private Category category;
    private String imagePath;
    private LocalDateTime createdAt;

    public Store(long id, String name, String description, Category category, String imagePath, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.imagePath = imagePath;
        this.createdAt = createdAt;
    }

    public Store(String name, String description, Category category, String imagePath) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.imagePath = imagePath;
    }

    public Store(long id, String name, String description, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
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

    public Category getCategory() {
        return category;
    }

    public String getImagePath() {
        return imagePath;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
