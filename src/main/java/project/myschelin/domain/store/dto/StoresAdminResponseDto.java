package project.myschelin.domain.store.dto;

import java.util.List;

public class StoresAdminResponseDto {
    private final List<StoreAdminResponseDto> stores;

    private StoresAdminResponseDto(List<StoreAdminResponseDto> stores) {
        this.stores = stores;
    }

    public static StoresAdminResponseDto from(List<StoreAdminResponseDto> stores) {
        return new StoresAdminResponseDto(stores);
    }

    public List<StoreAdminResponseDto> getStores() {
        return stores;
    }
}
