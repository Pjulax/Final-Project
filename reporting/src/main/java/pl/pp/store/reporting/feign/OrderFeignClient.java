package pl.pp.store.reporting.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import pl.pp.store.reporting.dto.StoreKeeperCredentialsDto;

@FeignClient(value = "ordersystem-service", path = "/product/stored")
public interface OrderFeignClient {

    @GetMapping("/{code}/all")
    ResponseEntity<Object> getOneStoredProductFromAllStores(@PathVariable(name = "code") String code, @RequestBody StoreKeeperCredentialsDto storeKeeperCredentialsDto);

    @GetMapping("/my")
    ResponseEntity<Object> getMyStoreStoredProducts(@RequestBody StoreKeeperCredentialsDto storeKeeperCredentialsDto);

    @GetMapping("/all")
    ResponseEntity<Object> getAllStoredProducts(@RequestBody StoreKeeperCredentialsDto storeKeeperCredentialsDto);
}

