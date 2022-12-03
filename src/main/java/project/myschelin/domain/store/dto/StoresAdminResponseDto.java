package project.myschelin.domain.store.dto;

import java.util.List;

public class StoresAdminResponseDto {
    private final List<StoreAdminResponseDto> stores;

    public StoresAdminResponseDto(List<StoreAdminResponseDto> stores) {
        this.stores = stores;
    }

    public List<StoreAdminResponseDto> getStores() {
        return stores;
    }
}
