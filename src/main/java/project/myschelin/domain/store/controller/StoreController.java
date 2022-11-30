package project.myschelin.domain.store.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.myschelin.domain.store.dto.StoreInsertRequestDto;
import project.myschelin.domain.store.dto.StoresResponseDto;
import project.myschelin.domain.store.service.StoreService;

import java.net.URI;

@RestController
public class StoreController {
    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/admin/api/v1/stores")
    public ResponseEntity<StoresResponseDto> findAllStores(@RequestParam(value = "pageNum", required = false) Integer pageNum) {
        StoresResponseDto storesResponseDto;
        if(pageNum == null) {
            storesResponseDto = new StoresResponseDto(storeService.findAllStores(1));
        } else {
            storesResponseDto = new StoresResponseDto(storeService.findAllStores(pageNum));
        }
        return ResponseEntity.ok(storesResponseDto);
    }

    @PostMapping("/admin/api/v1/stores")
    public ResponseEntity<Void> enrollStore(@RequestBody StoreInsertRequestDto storeInsertRequestDto) {
        long storeId = storeService.saveStore(storeInsertRequestDto);
        return ResponseEntity.created(URI.create("/admin/api/v1/stores/" + storeId)).build();
    }


}
