package project.myschelin.domain.store.dto;

import java.util.List;

public class StoresDashboardResponseDto {
    private List<StoreDashboardResponseDto> stores;

    private StoresDashboardResponseDto(List<StoreDashboardResponseDto> stores) {
        this.stores = stores;
    }

    public static StoresDashboardResponseDto from(List<StoreDashboardResponseDto> stores) {
        return new StoresDashboardResponseDto(stores);
    }

    public List<StoreDashboardResponseDto> getStores() {
        return stores;
    }
}
