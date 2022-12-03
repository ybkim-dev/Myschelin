package project.myschelin.domain.store.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.myschelin.domain.store.dto.*;
import project.myschelin.domain.store.service.StoreService;

import java.net.URI;

@RestController
public class StoreController {
    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/admin/api/v1/stores")
    public ResponseEntity<StoresAdminResponseDto> findAllStores(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum) {
        StoresAdminResponseDto storesAdminResponseDto = StoresAdminResponseDto.from(storeService.findAllStores(pageNum));
        return ResponseEntity.ok(storesAdminResponseDto);
    }

    @PostMapping("/admin/api/v1/stores")
    public ResponseEntity<Void> enrollStore(@ModelAttribute StoreAdminInsertRequestDto storeAdminInsertRequestDto) {
        long storeId = storeService.saveStore(storeAdminInsertRequestDto);
        return ResponseEntity.created(URI.create("/admin/api/v1/stores/" + storeId)).build();
    }

    @PutMapping("/admin/api/v1/stores/{storeId}")
    public ResponseEntity<Void> modifyStore(@PathVariable("storeId") long storeId, @RequestBody StoreUpdateRequestDto storeUpdateRequestDto) {
        storeService.updateStore(storeId, storeUpdateRequestDto);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/admin/api/v1/stores/{storeId}")
    public ResponseEntity<StoreAdminDetailResponseDto> findStore(@PathVariable("storeId") long storeId) {
        return ResponseEntity.ok(storeService.findStoreById(storeId));
    }

    @DeleteMapping("/admin/api/v1/stores/{storeId}")
    public ResponseEntity<Void> deleteStore(@PathVariable("storeId") long storeId) {
        storeService.deleteStoreById(storeId);
        return ResponseEntity.ok().build();
    }

}
