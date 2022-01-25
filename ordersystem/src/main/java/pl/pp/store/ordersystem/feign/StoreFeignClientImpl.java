package pl.pp.store.ordersystem.feign;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.pp.store.ordersystem.dto.StoreDto;
import pl.pp.store.ordersystem.dto.StoreKeeperCredentialsDto;
import pl.pp.store.ordersystem.dto.StoreListDto;

@RequiredArgsConstructor
@Service
@Slf4j
public class StoreFeignClientImpl {

    private final StoreFeignClient storeFeignClient;

    public StoreListDto getAllStoresRequest(StoreKeeperCredentialsDto credentialsDto) {
        ResponseEntity<Object> response = storeFeignClient.getAllStores(credentialsDto);
        if (response.getStatusCode().isError())
            throw new ResponseStatusException(response.getStatusCode(), (String) response.getBody());
        log.debug("Request sent\nStatus code is: {}", response.getStatusCode());
        return (StoreListDto) response.getBody();
    }

    public StoreDto getMyStoreRequest(StoreKeeperCredentialsDto credentialsDto) {
        ResponseEntity<Object> response = storeFeignClient.getMyStore(credentialsDto);
        if (response.getStatusCode().isError())
            throw new ResponseStatusException(response.getStatusCode(), (String) response.getBody());
        log.debug("Request sent\nStatus code is: {}", response.getStatusCode());
        return (StoreDto) response.getBody();
    }

    public StoreDto getOneStoreRequest(String code, StoreKeeperCredentialsDto credentialsDto) {
        ResponseEntity<Object> response = storeFeignClient.getOneStore(code, credentialsDto);
        if (response.getStatusCode().isError())
            throw new ResponseStatusException(response.getStatusCode(), (String) response.getBody());
        log.debug("Request sent\nStatus code is: {}", response.getStatusCode());
        return (StoreDto) response.getBody();
    }

    public String isStoreKeeperFromStoreRequest(StoreKeeperCredentialsDto credentialsDto) {
        ResponseEntity<String> response = storeFeignClient.isStoreKeeperFromStore(credentialsDto);
        if (response.getStatusCode().isError())
            throw new ResponseStatusException(response.getStatusCode(), response.getBody());
        log.debug("Request sent\nStatus code is: {}", response.getStatusCode());
        return response.getBody();
    }

}
