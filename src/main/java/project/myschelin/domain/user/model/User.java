package project.myschelin.domain.user.model;

import java.time.LocalDateTime;

public class User {
    private long id;
    private String nickname;
    private String email;
    private LocalDateTime createdAt;

    public User(long id, String nickname, String email, LocalDateTime createdAt) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.createdAt = createdAt;
    }

    public User(String nickname, String email) {
        this.nickname = nickname;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
