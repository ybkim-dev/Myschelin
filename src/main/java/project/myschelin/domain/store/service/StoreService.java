package project.myschelin.domain.store.service;

import org.springframework.stereotype.Service;
import project.myschelin.domain.store.dto.*;
import project.myschelin.domain.store.model.Store;
import project.myschelin.domain.store.repository.FileLocalRepository;
import project.myschelin.domain.store.repository.StoreRepository;

import java.util.List;

@Service
public class StoreService {
    private final StoreRepository storeRepository;
    private final FileLocalRepository fileLocalRepository = new FileLocalRepository();

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public List<StoreAdminResponseDto> findAllStores(int pageNum) {
        List<Store> stores = storeRepository.findStores(pageNum);
        return stores.stream().map(StoreAdminResponseDto::from).toList();
    }

    public List<Store> findAllStoresByUserId(long userId, int pageNum) {
        return storeRepository.findStoresByUserId(userId, pageNum);
    }

    public StoreAdminDetailResponseDto findStoreById(long storeId) {
        Store store = storeRepository.findStoreById(storeId);
        return StoreAdminDetailResponseDto.from(store);
    }

    public synchronized long saveStore(StoreInsertRequestDto storeInsertRequestDto) {
        String imagePath = fileLocalRepository.save(storeInsertRequestDto.getImageFile());
        storeInsertRequestDto.setImagePath(imagePath);
        Store store = storeInsertRequestDto.toStore();
        return storeRepository.insertStore(store);
    }

    public void updateStore(long storeId, StoreUpdateRequestDto storeUpdateRequestDto) {
        Store store = storeUpdateRequestDto.toStore(storeId);
        storeRepository.updateStore(store);
    }

    public void deleteStoreById(long storeId) {
        storeRepository.deleteStoreById(storeId);
    }
}
