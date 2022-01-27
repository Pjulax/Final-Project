package pl.pp.store.reporting.feign;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import pl.pp.store.reporting.dto.*;

import java.util.Collections;

@Component
public class OrderFeignClientFallback implements OrderFeignClient {
    @Override
    public ResponseEntity<StoredProductStoresListDto> getOneStoredProductFromAllStores(String code, StoreKeeperCredentialsDto storeKeeperCredentialsDto) {
        return new ResponseEntity<>(new StoredProductStoresListDto("", CategoryType.UNKNOWN, "", Collections.emptyList()), HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<StoredProductsListDto> getMyStoreStoredProducts(StoreKeeperCredentialsDto storeKeeperCredentialsDto) {
        return new ResponseEntity<>(new StoredProductsListDto(new StoreDto(),Collections.emptyList()), HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<AllStoresStoredProductsListDto> getAllStoredProducts(StoreKeeperCredentialsDto storeKeeperCredentialsDto) {
        return new ResponseEntity<>(new AllStoresStoredProductsListDto(Collections.emptyList()), HttpStatus.BAD_REQUEST);
    }
}
