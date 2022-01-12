package pl.pp.store.reporting.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pp.store.reporting.dto.StoredProductsListDto;
import pl.pp.store.reporting.service.ProductService;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<StoredProductsListDto> getAllStoredProducts(){
        return ResponseEntity.ok(productService.getAllStoredProducts());
    }
}
