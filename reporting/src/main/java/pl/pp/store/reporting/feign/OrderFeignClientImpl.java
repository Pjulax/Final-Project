package pl.pp.store.reporting.feign;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.pp.store.reporting.dto.AllStoresStoredProductsListDto;
import pl.pp.store.reporting.dto.StoreKeeperCredentialsDto;
import pl.pp.store.reporting.dto.StoredProductStoresListDto;
import pl.pp.store.reporting.dto.StoredProductsListDto;

@RequiredArgsConstructor
@Service
@Slf4j
public class OrderFeignClientImpl {

    private final OrderFeignClient orderFeignClient;

    public StoredProductStoresListDto getOneStoredProductFromAllStores(String code, StoreKeeperCredentialsDto storeKeeperCredentialsDto) {
        ResponseEntity<StoredProductStoresListDto> response = orderFeignClient.getOneStoredProductFromAllStores(code, storeKeeperCredentialsDto);
        if (response.getStatusCode().isError())
            throw new ResponseStatusException(response.getStatusCode(), "Something went wrong, it is fallback.");
        log.debug("Request sent\nStatus code is: {}", response.getStatusCode());
        return  response.getBody();
    }

    public StoredProductsListDto getMyStoreStoredProducts(StoreKeeperCredentialsDto storeKeeperCredentialsDto) {
        ResponseEntity<StoredProductsListDto> response = orderFeignClient.getMyStoreStoredProducts(storeKeeperCredentialsDto);
        if (response.getStatusCode().isError())
            throw new ResponseStatusException(response.getStatusCode(), "Something went wrong, it is fallback.");
        log.debug("Request sent\nStatus code is: {}", response.getStatusCode());
        return  response.getBody();
    }

    public AllStoresStoredProductsListDto getAllStoredProducts(StoreKeeperCredentialsDto storeKeeperCredentialsDto) {
        ResponseEntity<AllStoresStoredProductsListDto> response = orderFeignClient.getAllStoredProducts(storeKeeperCredentialsDto);
        if (response.getStatusCode().isError())
            throw new ResponseStatusException(response.getStatusCode(), "Something went wrong, it is fallback.");
        log.debug("Request sent\nStatus code is: {}", response.getStatusCode());
        return  response.getBody();
    }

}
