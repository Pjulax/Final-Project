package pl.pp.store.ordersystem.feign;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import pl.pp.store.ordersystem.dto.StoreDto;
import pl.pp.store.ordersystem.dto.StoreKeeperCredentialsDto;
import pl.pp.store.ordersystem.dto.StoreListDto;

import java.util.Collections;

@Component
public class StoreFeignClientFallback implements StoreFeignClient {

    @Override
    public ResponseEntity<StoreListDto> getAllStores(StoreKeeperCredentialsDto credentialsDto) {
        return new ResponseEntity<StoreListDto>(new StoreListDto(Collections.emptyList()), HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<StoreDto> getMyStore(StoreKeeperCredentialsDto credentialsDto) {
        return new ResponseEntity<StoreDto>(new StoreDto(), HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<StoreDto> getOneStore(String code, StoreKeeperCredentialsDto credentialsDto) {
        return new ResponseEntity<StoreDto>(new StoreDto(), HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<String> isStoreKeeperFromStore(StoreKeeperCredentialsDto credentialsDto) {
        return new ResponseEntity<String>("Access forbidden.", HttpStatus.FORBIDDEN);
    }
}
