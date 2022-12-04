package project.myschelin.domain.user.dto;

import project.myschelin.domain.user.model.User;

public class UserInsertRequestDto {
    private final String nickname;
    private final String email;

    public UserInsertRequestDto(String nickname, String email) {
        this.nickname = nickname;
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public User toUser() {
        return new User(nickname, email);
    }
}
