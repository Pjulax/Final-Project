package pl.pp.store.ordersystem.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pp.store.ordersystem.dto.ProductDto;
import pl.pp.store.ordersystem.dto.ProductsListDto;
import pl.pp.store.ordersystem.dto.StoreKeeperCredentialsDto;
import pl.pp.store.ordersystem.service.ProductService;


@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "Add a product to database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully added product."),
            @ApiResponse(responseCode = "400", description = "Product with that code already exists, code must be unique.")
    })
    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestBody ProductDto productDto) {
        productService.addProduct(productDto);
        return ResponseEntity.ok("Ok");
    }

    @Operation(summary = "")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully added store"),
            @ApiResponse(responseCode = "403", description = "Store with that code already exists or storekeeper with that login doesn't exist.")
    })
    @GetMapping("/all")
    public ResponseEntity<ProductsListDto> getAllProducts(@RequestBody StoreKeeperCredentialsDto storeKeeperCredentialsDto) {
        return ResponseEntity.ok(productService.getAllProducts(storeKeeperCredentialsDto));
    }
}