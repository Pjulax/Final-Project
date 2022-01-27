package pl.pp.store.ordersystem.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.pp.store.ordersystem.dto.ProductDto;
import pl.pp.store.ordersystem.dto.ProductsListDto;
import pl.pp.store.ordersystem.dto.StoreKeeperCredentialsDto;
import pl.pp.store.ordersystem.dto.StoredProductDto;
import pl.pp.store.ordersystem.feign.StoreFeignClientImpl;
import pl.pp.store.ordersystem.repository.ProductRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final StoreFeignClientImpl storeFeignClient;

    public void addProduct(ProductDto productDto) {
        if (productRepository.findByCode(productDto.getCode()).isPresent()){
                 throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product with that code exists, code must be unique.");
        }
        productRepository.save(productDto.toDomain());
    }

    public ProductsListDto getAllProducts(StoreKeeperCredentialsDto storeKeeperCredentialsDto) {
        storeFeignClient.isStoreKeeperFromStoreRequest(storeKeeperCredentialsDto);
        return ProductsListDto.fromDomain(productRepository.findAll());
    }

}
