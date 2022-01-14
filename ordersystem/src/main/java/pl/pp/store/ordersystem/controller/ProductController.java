package pl.pp.store.ordersystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pp.store.ordersystem.dto.StoredProductsListDto;
import pl.pp.store.ordersystem.service.ProductService;

@RestController
@RequestMapping("/store")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<StoredProductsListDto> getAllStoredProducts(){
        return ResponseEntity.ok(productService.getAllStoredProducts());
    }

    @GetMapping("/my")
    public ResponseEntity<StoredProductsListDto> getMyStoredProducts(){
        // TODO add user as storekeeper
        // return ResponseEntity.ok(productService.getMyStoredProducts(user));
        return ResponseEntity.ok(productService.getMyStoredProducts());
    }

    @GetMapping("/{code}")
    public ResponseEntity<StoredProductsListDto> getStoredProducts(@PathVariable(name = "code")String code){
        // TODO add user as storekeeper
        // return ResponseEntity.ok(productService.getMyStoredProducts(user));
        return ResponseEntity.ok(productService.getMyStoredProducts());
    }

    //@GetMapping("/articles/all")

}
