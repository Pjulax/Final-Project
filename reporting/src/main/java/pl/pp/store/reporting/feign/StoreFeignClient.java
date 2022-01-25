package pl.pp.store.reporting.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import pl.pp.store.reporting.dto.StoreKeeperCredentialsDto;

@FeignClient("store-service")
public interface StoreFeignClient {

    @GetMapping("/all")
    ResponseEntity<Object> getAllStores(@RequestBody StoreKeeperCredentialsDto credentialsDto);

    @GetMapping("/my")
    ResponseEntity<Object> getMyStore(@RequestBody StoreKeeperCredentialsDto credentialsDto);

    @GetMapping("/{code}")
    ResponseEntity<Object> getOneStore(@PathVariable String code, @RequestBody StoreKeeperCredentialsDto credentialsDto);

    @GetMapping("/storekeeper/auth")
    ResponseEntity<String> isStoreKeeperFromStore(@RequestBody StoreKeeperCredentialsDto credentialsDto);

}

