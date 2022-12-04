package project.myschelin.domain.user.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import project.myschelin.domain.store.model.Category;
import project.myschelin.domain.store.model.Store;
import project.myschelin.domain.user.model.User;
import project.myschelin.exception.repository.EntityNotInsertException;

import java.text.MessageFormat;
import java.time.LocalDateTime;

@Repository
public class BasicUserRepository implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public BasicUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final RowMapper<User> userRowMapper = (resultSet, i) -> {
        long userId = resultSet.getLong("user_id");
        String nickname = resultSet.getString("nickname");
        String email = resultSet.getString("email");
        LocalDateTime createdAt = resultSet.getTimestamp("created_at").toLocalDateTime();
        return new User(userId, nickname, email, createdAt);
    };

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public long insertUser(User user) {
        int update = jdbcTemplate.update("insert into users(nickname, email) values(?,?)",
                user.getNickname(),
                user.getEmail());
        if(update != 1)
            throw new EntityNotInsertException(MessageFormat.format("엔티티가 추가되지 않았습니다. Entity = {0}", user));
        return jdbcTemplate.queryForObject("select last_insert_id()", Long.class);
    }

    @Override
    public User findUserById(long userId) {
        return jdbcTemplate.queryForObject("select * from users where user_id = ?", userRowMapper, userId);
    }
}
