package pl.pp.store.ordersystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pp.store.ordersystem.dto.*;
import pl.pp.store.ordersystem.service.StoredProductService;

@RestController
@RequestMapping("/product/stored")
@RequiredArgsConstructor
public class StoredProductController {

    private final StoredProductService storedProductService;

    @GetMapping("/{code}")
    public ResponseEntity<StoredProductDto> getOneStoredProduct(@PathVariable(name = "code") String code, @RequestBody StoreKeeperCredentialsDto storeKeeperCredentialsDto) {
        return ResponseEntity.ok(storedProductService.getOneStoredProduct(code, storeKeeperCredentialsDto));
    }

    @GetMapping("/{code}/all")
    public ResponseEntity<StoredProductStoresListDto> getOneStoredProductFromAllStores(@PathVariable(name = "code") String code, @RequestBody StoreKeeperCredentialsDto storeKeeperCredentialsDto) {
        return ResponseEntity.ok(storedProductService.getOneStoredProductFromAllStores(code, storeKeeperCredentialsDto));
    }

    @GetMapping("/my")
    public ResponseEntity<StoredProductsListDto> getMyStoreStoredProducts(@RequestBody StoreKeeperCredentialsDto credentials) {
        return ResponseEntity.ok(storedProductService.getMyStoreStoredProducts(credentials));
    }

    @GetMapping("/all")
    public ResponseEntity<AllStoresStoredProductsListDto> getAllStoredProducts(@RequestBody StoreKeeperCredentialsDto storeKeeperCredentialsDto) {
        return ResponseEntity.ok(storedProductService.getAllStoredProducts(storeKeeperCredentialsDto));
    }
}