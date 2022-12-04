package project.myschelin.domain.store.repository;

import project.myschelin.domain.store.model.Store;

import java.util.List;

public interface StoreRepository {

    List<Store> findStoresByUserId(long userId, int pageNum);
    List<Store> findStores(int pageNum);
    List<Store> findStoresByName(String name, int pageNum);
    Store findStoreById(long storeId);
    void insertLike(long userId, long storeId);
    long insertStore(Store store);
    void updateStore(Store store);

    void deleteStoreById(long storeId);
}
