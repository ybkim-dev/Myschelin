package project.myschelin.domain.user.dto;

import project.myschelin.domain.user.model.User;

public class UserResponseDto {
    private long id;
    private String nickname;
    private String email;

    private UserResponseDto(long id, String nickname, String email) {
        this.id = id;
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

    public static UserResponseDto from(User user) {
        return new UserResponseDto(user.getId(), user.getNickname(), user.getEmail());
    }
}
