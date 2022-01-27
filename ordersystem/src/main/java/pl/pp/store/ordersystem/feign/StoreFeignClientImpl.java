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
        ResponseEntity<StoreListDto> response = storeFeignClient.getAllStores(credentialsDto);
        if (response.getStatusCode().isError())
            throw new ResponseStatusException(response.getStatusCode(), "Something went wrong, it is fallback.");
        log.debug("Request sent\nStatus code is: {}", response.getStatusCode());
        return response.getBody();
    }

    public StoreDto getMyStoreRequest(StoreKeeperCredentialsDto credentialsDto) {
        ResponseEntity<StoreDto> response = storeFeignClient.getMyStore(credentialsDto);
        if (response.getStatusCode().isError())
            throw new ResponseStatusException(response.getStatusCode(), "Something went wrong, it is fallback.");
        log.debug("Request sent\nStatus code is: {}", response.getStatusCode());
        return response.getBody();
    }

    public StoreDto getOneStoreRequest(String code, StoreKeeperCredentialsDto credentialsDto) {
        ResponseEntity<StoreDto> response = storeFeignClient.getOneStore(code, credentialsDto);
        if (response.getStatusCode().isError())
            throw new ResponseStatusException(response.getStatusCode(), "Something went wrong, it is fallback.");
        log.debug("Request sent\nStatus code is: {}", response.getStatusCode());
        return response.getBody();
    }

    public String isStoreKeeperFromStoreRequest(StoreKeeperCredentialsDto credentialsDto) {
        ResponseEntity<String> response = storeFeignClient.isStoreKeeperFromStore(credentialsDto);
        if (response.getStatusCode().isError())
            throw new ResponseStatusException(response.getStatusCode(), "Something went wrong, it is fallback.");
        log.debug("Request sent\nStatus code is: {}", response.getStatusCode());
        return response.getBody();
    }

}
