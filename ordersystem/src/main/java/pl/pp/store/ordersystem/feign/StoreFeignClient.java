package pl.pp.store.ordersystem.feign;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pp.store.ordersystem.dto.StoreDto;
import pl.pp.store.ordersystem.dto.StoreKeeperCredentialsDto;
import pl.pp.store.ordersystem.dto.StoreListDto;

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

