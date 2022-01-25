package pl.pp.store.ordersystem.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.pp.store.ordersystem.dto.StoreKeeperCredentialsDto;
import pl.pp.store.ordersystem.dto.SuppliesListDto;
import pl.pp.store.ordersystem.dto.SupplyDto;
import pl.pp.store.ordersystem.feign.StoreFeignClientImpl;
import pl.pp.store.ordersystem.model.Product;
import pl.pp.store.ordersystem.model.StoredProduct;
import pl.pp.store.ordersystem.model.Supply;
import pl.pp.store.ordersystem.repository.ProductRepository;
import pl.pp.store.ordersystem.repository.StoredProductRepository;
import pl.pp.store.ordersystem.repository.SupplyRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class SupplyService {
    private final SupplyRepository supplyRepository;
    private final ProductRepository productRepository;
    private final StoredProductRepository storedProductRepository;
    private final StoreFeignClientImpl storeFeignClient;

    public void addSupply(SupplyDto supplyDto) {
        if (supplyRepository.findByCode(supplyDto.getCode()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Supply with that code exists, code must be unique.");
        }
        Product product = productRepository.findByCode(supplyDto.getProductCode())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product from that supply doesn't exist."));
        supplyRepository.save(supplyDto.toDomain(product));
    }

    public void acceptSupply(String code, StoreKeeperCredentialsDto storeKeeperCredentialsDto) {
        storeFeignClient.isStoreKeeperFromStoreRequest(storeKeeperCredentialsDto);
        Supply supply = supplyRepository.findByCode(code)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Supply with that code doesn't exist."));
        if (supply.getIsAccepted()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Supply with that code already is accepted.");
        }
        StoredProduct storedProduct = storedProductRepository.findByStoreCodeAndProduct_Code(supply.getTargetStoreCode(), supply.getProduct().getCode())
                .orElse(StoredProduct.builder()
                        .product(supply.getProduct())
                        .storeCode(supply.getTargetStoreCode())
                        .quantity(supply.getQuantity())
                        .build());

        if (storedProduct.getId() != null) {
            storedProduct.setQuantity(storedProduct.getQuantity() + supply.getQuantity());
        }
        storedProductRepository.save(storedProduct);
        supply.setIsAccepted(true);
        supplyRepository.save(supply);
    }

    public SuppliesListDto getAllSuppliesFromMyStore(StoreKeeperCredentialsDto storeKeeperCredentialsDto) {
        storeFeignClient.isStoreKeeperFromStoreRequest(storeKeeperCredentialsDto);
        return SuppliesListDto.fromDomain(supplyRepository.findAllByTargetStoreCode(storeKeeperCredentialsDto.getStoreCode()));
    }
}
