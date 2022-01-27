package pl.pp.store.ordersystem.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
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

    @Operation(summary = "Get all products information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully provided information about products"),
            @ApiResponse(responseCode = "403", description = "Not found store and user to authorize. Access forbidden.")
    })
    @GetMapping("/all")
    public ResponseEntity<ProductsListDto> getAllProducts(@ParameterObject StoreKeeperCredentialsDto storeKeeperCredentialsDto) {
        return ResponseEntity.ok(productService.getAllProducts(storeKeeperCredentialsDto));
    }
}