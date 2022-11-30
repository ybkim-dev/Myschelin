package project.myschelin.domain.store.model;

import java.time.LocalDateTime;

public class Store {
    private final long id;
    private final String name;
    private final String description;
    private final Category category;
    private final String imagePath;
    private final LocalDateTime createdAt;

    public Store(long id, String name, String description, Category category, String imagePath, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.imagePath = imagePath;
        this.createdAt = createdAt;
    }
}
