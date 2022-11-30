package project.myschelin.domain.store.repository;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import project.myschelin.domain.store.model.Category;
import project.myschelin.domain.store.model.Store;
import project.myschelin.exception.database.EntityNotDeleteException;
import project.myschelin.exception.database.EntityNotFoundException;
import project.myschelin.exception.database.EntityNotInsertException;
import project.myschelin.exception.database.EntityNotUpdateException;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Repository
public class BasicStoreRepository implements StoreRepository {

    private final JdbcTemplate jdbcTemplate;

    public BasicStoreRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final RowMapper<Store> storeRowMapper = (resultSet, i) -> {
        long storeId = resultSet.getLong("store_id");
        String name = resultSet.getString("name");
        String description = resultSet.getString("description");
        Category category = Category.valueOf(resultSet.getString("category"));
        String imagePath = resultSet.getString("image_path");
        LocalDateTime createdAt = resultSet.getTimestamp("created_at").toLocalDateTime();
        return new Store(storeId, name, name, category, imagePath, createdAt);
    };

    @Override
    public List<Store> findStoresByUserId(long userId, int pageNum) {
        // wish table & store table join
        /**
         * TODO : pageNum 받아서 Limit, Offset 처리 코드  추가
         */
        List<Store> storesByUserId = jdbcTemplate.query("select * from wishes w inner join stores s on w.store_id = s.store_id where w.user_id = ?",
                storeRowMapper,
                userId);
        return storesByUserId;
    }

    @Override
    public List<Store> findStores(int pageNum) {
        List<Store> stores = jdbcTemplate.query("select * from stores", storeRowMapper);
        return stores;
    }

    @Override
    public Store findStoreById(long storeId) {
        try {
            return jdbcTemplate.queryForObject("select * from stores where store_id = ?", storeRowMapper, storeId);
        } catch (EmptyResultDataAccessException e) {
            // TODO logging이 들어갈 지 말지 고민중
            throw new EntityNotFoundException(MessageFormat.format("해당 Id를 가진 엔티티가 없습니다. Entity id = {0}", storeId));
        }
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public long insertStore(Store store) {
        int update = jdbcTemplate.update("insert into stores(`name`, description, category, image_path) values(?,?,?,?)",
                store.getName(),
                store.getDescription(),
                store.getCategory().getEnglishName(),
                store.getImagePath());
        if (update != 1)
            throw new EntityNotInsertException(MessageFormat.format("엔티티가 추가되지 않았습니다. Entity = {0}", store));

        return jdbcTemplate.queryForObject("select last_insert_id()", Long.class);
    }

    @Override
    public void updateStore(Store store) {
        int update = jdbcTemplate.update("update stores set name = ?, description = ?, category = ? where store_id = ?",
                store.getName(),
                store.getDescription(),
                store.getCategory().getEnglishName(),
                store.getId()
        );
        if (update != 1)
            throw new EntityNotUpdateException(MessageFormat.format("엔티티가 수정되지 않았습니다. Entity = {0}", store));
    }

    @Override
    public void deleteStoreById(long storeId) {
        int update = jdbcTemplate.update("delete from stores where store_id = ?", storeId);
        if(update != 1)
            throw new EntityNotDeleteException(MessageFormat.format("엔티티가 삭제되지 않았습니다. Entity id = {0}", storeId));
    }
}
