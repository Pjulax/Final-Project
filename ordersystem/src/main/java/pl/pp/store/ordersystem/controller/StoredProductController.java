package pl.pp.store.ordersystem.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pp.store.ordersystem.dto.*;
import pl.pp.store.ordersystem.service.StoredProductService;

@RestController
@RequestMapping("/product/stored")
@RequiredArgsConstructor
public class StoredProductController {

    private final StoredProductService storedProductService;

    @Operation(summary = "Get one stored product from my store information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully provided information about stored product."),
            @ApiResponse(responseCode = "400", description = "Product doesn't exist in that store."),
            @ApiResponse(responseCode = "403", description = "Not found store and user to authorize. Access forbidden.")
    })
    @GetMapping("/{code}")
    public ResponseEntity<StoredProductDto> getOneStoredProduct(@PathVariable(name = "code") String code, @ParameterObject StoreKeeperCredentialsDto storeKeeperCredentialsDto) {
        return ResponseEntity.ok(storedProductService.getOneStoredProduct(code, storeKeeperCredentialsDto));
    }

    @Operation(summary = "Get one stored product from all stores information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully provided information about stored product."),
            @ApiResponse(responseCode = "403", description = "Not found store and user to authorize. Access forbidden.")
    })
    @GetMapping("/{code}/all")
    public ResponseEntity<StoredProductStoresListDto> getOneStoredProductFromAllStores(@PathVariable(name = "code") String code, @ParameterObject StoreKeeperCredentialsDto storeKeeperCredentialsDto) {
        return ResponseEntity.ok(storedProductService.getOneStoredProductFromAllStores(code, storeKeeperCredentialsDto));
    }

    @Operation(summary = "Get all stored products in my store information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully provided information about stored products."),
            @ApiResponse(responseCode = "403", description = "Not found store and user to authorize. Access forbidden.")
    })
    @GetMapping("/my")
    public ResponseEntity<StoredProductsListDto> getMyStoreStoredProducts(@ParameterObject StoreKeeperCredentialsDto credentials) {
        return ResponseEntity.ok(storedProductService.getMyStoreStoredProducts(credentials));
    }

    @Operation(summary = "Get all stored products from all stores information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully provided information about stored products."),
            @ApiResponse(responseCode = "403", description = "Not found store and user to authorize. Access forbidden.")
    })
    @GetMapping("/all")
    public ResponseEntity<AllStoresStoredProductsListDto> getAllStoredProducts(@ParameterObject StoreKeeperCredentialsDto storeKeeperCredentialsDto) {
        return ResponseEntity.ok(storedProductService.getAllStoredProducts(storeKeeperCredentialsDto));
    }
}