package pl.pp.store.reporting.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.pp.store.reporting.dto.AllStoresStoredProductsListDto;
import pl.pp.store.reporting.dto.StoreKeeperCredentialsDto;
import pl.pp.store.reporting.dto.StoredProductStoresListDto;
import pl.pp.store.reporting.dto.StoredProductsListDto;

@FeignClient(value = "ordersystem-service", path = "/product/stored", fallback = OrderFeignClientFallback.class)
public interface OrderFeignClient {

    @GetMapping("/{code}/all")
    ResponseEntity<StoredProductStoresListDto> getOneStoredProductFromAllStores(@PathVariable(name = "code") String code, @SpringQueryMap StoreKeeperCredentialsDto storeKeeperCredentialsDto);

    @GetMapping("/my")
    ResponseEntity<StoredProductsListDto> getMyStoreStoredProducts(@SpringQueryMap StoreKeeperCredentialsDto storeKeeperCredentialsDto);

    @GetMapping("/all")
    ResponseEntity<AllStoresStoredProductsListDto> getAllStoredProducts(@SpringQueryMap StoreKeeperCredentialsDto storeKeeperCredentialsDto);
}

