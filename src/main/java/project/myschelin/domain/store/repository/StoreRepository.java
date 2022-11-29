package project.myschelin.domain.store.repository;

import project.myschelin.domain.store.model.Store;

import java.util.List;
import java.util.Optional;

public interface StoreRepository {

    List<Store> findStoresByUserId(long userId, int pageNum);
    List<Store> findStores(int pageNum);
    Optional<Store> findStoreById(long storeId);

    Store insertStore(Store store);
    Store updateStore(Store store);

    void deleteStoreById(long storeId);
}
