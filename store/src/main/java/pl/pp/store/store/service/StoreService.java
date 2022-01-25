package pl.pp.store.store.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.pp.store.store.dto.AddStoreDto;
import pl.pp.store.store.dto.StoreDto;
import pl.pp.store.store.dto.StoreKeeperCredentialsDto;
import pl.pp.store.store.dto.StoreListDto;
import pl.pp.store.store.model.Store;
import pl.pp.store.store.model.StoreKeeper;
import pl.pp.store.store.repository.StoreKeeperRepository;
import pl.pp.store.store.repository.StoreRepository;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;
    private final StoreKeeperRepository storeKeeperRepository;

    public void addStore(AddStoreDto addStoreDto) {
        if(storeRepository.findByCode(addStoreDto.getCode()).isPresent())
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Store with that code already exists.");

        StoreKeeper storeKeeper = storeKeeperRepository.findByLogin(addStoreDto.getStorekeeperLogin())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Storekeeper with that login doesn't exist."));
        Store store = addStoreDto.toDomain();
        store.setStoreKeeper(storeKeeper);
        storeRepository.save(store);
    }

    public StoreListDto getAllStores(StoreKeeperCredentialsDto credentialsDto) {
        authorize(credentialsDto);
        return StoreListDto.fromDomain(storeRepository.findAll());
    }

    public StoreDto getOneStore(String code, StoreKeeperCredentialsDto credentialsDto) {
        authorize(credentialsDto);
        return storeRepository.findByCode(code)
                .map(StoreDto::fromDomain)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not found store with code " + code));
    }

    public StoreDto getMyStore(StoreKeeperCredentialsDto credentialsDto) {
        return authorize(credentialsDto);
    }

    public StoreDto authorize(StoreKeeperCredentialsDto credentialsDto) {
        return storeRepository.findByCodeAndStoreKeeper_LoginAndStoreKeeper_Password(credentialsDto.getStoreCode(), credentialsDto.getLogin(), credentialsDto.getPassword())
                .map(StoreDto::fromDomain)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.FORBIDDEN, "Not found store and user. Access forbidden."));
    }
}
