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

    public List<StoreDashboardResponseDto> findAllStoresByName(String name, int pageNum) {
        List<Store> stores = storeRepository.findStoresByName(name, pageNum);
        return stores.stream().map(StoreDashboardResponseDto::from).toList();
    }

    public List<StoreDashboardResponseDto> findAllStoresByUserId(long userId, int pageNum) {
        List<Store> stores = storeRepository.findStoresByUserId(userId, pageNum);
        return stores.stream().map(StoreDashboardResponseDto::from).toList();
    }

    public StoreAdminDetailResponseDto findStoreById(long storeId) {
        Store store = storeRepository.findStoreById(storeId);
        return StoreAdminDetailResponseDto.from(store);
    }

    public void createLike(long userId, long storeId) {
        storeRepository.insertLike(userId, storeId);
    }

    public synchronized long saveStore(StoreAdminInsertRequestDto storeAdminInsertRequestDto) {
        String imagePath = fileLocalRepository.save(storeAdminInsertRequestDto.getImageFile());
        storeAdminInsertRequestDto.setImagePath(imagePath);
        Store store = storeAdminInsertRequestDto.toStore();
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
