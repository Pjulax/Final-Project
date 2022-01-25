package pl.pp.store.store.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.pp.store.store.dto.StoreKeeperCredentialsDto;
import pl.pp.store.store.dto.StoreKeeperDataDto;
import pl.pp.store.store.dto.StoreKeeperDto;
import pl.pp.store.store.repository.StoreKeeperRepository;

@Service
@RequiredArgsConstructor
public class StoreKeeperService {
    private final StoreKeeperRepository storeKeeperRepository;
    private final StoreService storeService;

    public void addStoreKeeper(StoreKeeperDto storeKeeperDto) {
        if (storeKeeperRepository.findByLogin(storeKeeperDto.getLogin()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Storekeeper with that login already exists.");
        }
        storeKeeperRepository.save(storeKeeperDto.toDomain());
    }

    public StoreKeeperDataDto getMyInfo(StoreKeeperCredentialsDto credentialsDto) {
        storeService.authorize(credentialsDto);
        return StoreKeeperDataDto.fromDomain(storeKeeperRepository.findByLogin(credentialsDto.getLogin()).get());
    }
}
