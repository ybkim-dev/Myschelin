package project.myschelin.domain.store.model;

public enum Category {
    MEAT("고깃집"), CAFE("카페"), KOREAN("한식");
    private String name;

    Category(String name) {
        this.name = name;
    }
}
