package project.myschelin.domain.user.service;

import org.springframework.stereotype.Service;
import project.myschelin.domain.user.dto.UserInsertRequestDto;
import project.myschelin.domain.user.dto.UserResponseDto;
import project.myschelin.domain.user.model.User;
import project.myschelin.domain.user.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public long saveUser(UserInsertRequestDto userInsertRequestDto) {
        User user = userInsertRequestDto.toUser();
       return userRepository.insertUser(user);
    }

    public UserResponseDto getUser(long userId) {
        User user = userRepository.findUserById(userId);
        return UserResponseDto.from(user);
    }
}
