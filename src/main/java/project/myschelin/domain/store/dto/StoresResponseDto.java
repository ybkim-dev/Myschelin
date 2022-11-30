package project.myschelin.domain.store.dto;

import project.myschelin.domain.store.model.Store;

import java.util.List;

public class StoresResponseDto {
    private List<Store> stores;

    public StoresResponseDto(List<Store> stores) {
        this.stores = stores;
    }

    public List<Store> getStores() {
        return stores;
    }
}
