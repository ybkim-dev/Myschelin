package project.myschelin.domain.store.service;

import org.springframework.stereotype.Service;
import project.myschelin.domain.store.dto.StoreInsertRequestDto;
import project.myschelin.domain.store.dto.StoreUpdateRequestDto;
import project.myschelin.domain.store.model.Store;
import project.myschelin.domain.store.repository.StoreRepository;

import java.util.List;

@Service
public class StoreService {
    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public List<Store> findAllStores(int pageNum) {
        return storeRepository.findStores(pageNum);
    }

    public List<Store> findAllStoresByUserId(long userId, int pageNum) {
        return storeRepository.findStoresByUserId(userId, pageNum);
    }

    public Store findStoreById(long storeId) {
        return storeRepository.findStoreById(storeId);
    }

    public long saveStore(StoreInsertRequestDto storeInsertRequestDto) {
        Store store = storeInsertRequestDto.toStore();
        return storeRepository.insertStore(store);
    }

    public void updateStore(StoreUpdateRequestDto storeUpdateRequestDto) {
        Store store = storeUpdateRequestDto.toStore();
        storeRepository.updateStore(store);
    }

    public void deleteStoreById(long storeId) {
        storeRepository.deleteStoreById(storeId);
    }
}
