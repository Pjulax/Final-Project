package pl.pp.store.reporting.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.pp.store.reporting.dto.StoreDto;
import pl.pp.store.reporting.dto.StoreKeeperCredentialsDto;
import pl.pp.store.reporting.dto.StoreListDto;

@FeignClient(value = "store-service", fallback = StoreFeignClientFallback.class)
public interface StoreFeignClient {

    @GetMapping("/all")
    ResponseEntity<StoreListDto> getAllStores(@SpringQueryMap StoreKeeperCredentialsDto credentialsDto);

    @GetMapping("/my")
    ResponseEntity<StoreDto> getMyStore(@SpringQueryMap StoreKeeperCredentialsDto credentialsDto);

    @GetMapping("/{code}")
    ResponseEntity<StoreDto> getOneStore(@PathVariable String code, @SpringQueryMap StoreKeeperCredentialsDto credentialsDto);

    @RequestMapping(method = RequestMethod.GET, value = "/storekeeper/auth")
    ResponseEntity<String> isStoreKeeperFromStore(@SpringQueryMap StoreKeeperCredentialsDto credentialsDto);

}

