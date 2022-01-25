package pl.pp.store.ordersystem.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.pp.store.ordersystem.dto.*;
import pl.pp.store.ordersystem.feign.StoreFeignClientImpl;
import pl.pp.store.ordersystem.model.StoredProduct;
import pl.pp.store.ordersystem.repository.StoredProductRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class StoredProductService {

    private final StoredProductRepository storedProductRepository;
    private final StoreFeignClientImpl storeFeignClient;

    public StoredProductDto getOneStoredProduct(String code, StoreKeeperCredentialsDto storeKeeperCredentialsDto) {
        storeFeignClient.isStoreKeeperFromStoreRequest(storeKeeperCredentialsDto);
        return storedProductRepository.findByStoreCodeAndProduct_Code(storeKeeperCredentialsDto.getStoreCode(), code).map(StoredProductDto::fromDomain)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product doesn't exist in that store"));
    }

    public StoredProductStoresListDto getOneStoredProductFromAllStores(String code, StoreKeeperCredentialsDto storeKeeperCredentialsDto) {
        storeFeignClient.isStoreKeeperFromStoreRequest(storeKeeperCredentialsDto);
        List<StoredProduct> storedProducts = storedProductRepository.findAllByProduct_Code(code);
        Map<String, StoredProduct> storedProductsMap = new HashMap<>();
        storedProducts.forEach(storedProduct -> storedProductsMap.put(storedProduct.getStoreCode(),storedProduct));
        StoreListDto storeList = storeFeignClient.getAllStoresRequest(storeKeeperCredentialsDto);
        Map<String, StoreDto> storesMap = new HashMap<>();
        storeList.getStoreList().forEach(storeDto -> storesMap.put(storeDto.getCode(), storeDto));
        return StoredProductStoresListDto.fromDomain(storesMap, storedProductsMap);
    }

    public StoredProductsListDto getMyStoreStoredProducts(StoreKeeperCredentialsDto storeKeeperCredentialsDto) {
        storeFeignClient.isStoreKeeperFromStoreRequest(storeKeeperCredentialsDto);
        StoreDto storeDto = storeFeignClient.getMyStoreRequest(storeKeeperCredentialsDto);
        List<StoredProduct> storedProductsList = storedProductRepository.findAllByStoreCode(storeDto.getCode());
        return StoredProductsListDto.fromDomain(storeDto, storedProductsList);
    }

    public AllStoresStoredProductsListDto getAllStoredProducts(StoreKeeperCredentialsDto storeKeeperCredentialsDto) {
        storeFeignClient.isStoreKeeperFromStoreRequest(storeKeeperCredentialsDto);
        StoreListDto storeListDto = storeFeignClient.getAllStoresRequest(storeKeeperCredentialsDto);
        List<StoredProduct> storedProductsList = storedProductRepository.findAll();
        return AllStoresStoredProductsListDto.fromDomain(storeListDto.getStoreList(), storedProductsList);
    }
}