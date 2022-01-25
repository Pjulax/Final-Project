package pl.pp.store.store.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pp.store.store.dto.*;
import pl.pp.store.store.service.StoreKeeperService;
import pl.pp.store.store.service.StoreService;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class StoreController {

    private final StoreService storeService;
    private final StoreKeeperService storeKeeperService;

    @Operation(summary = "Add a store to database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully added store"),
            @ApiResponse(responseCode = "400", description = "Store with that code already exists or storekeeper with that login doesn't exist.")
    })
    @PostMapping("/add")
    public ResponseEntity<String> addStore(@RequestBody AddStoreDto addStoreDto) {
        storeService.addStore(addStoreDto);
        return ResponseEntity.ok(null);
    }

    @Operation(summary = "Add a store to database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully got stores list"),
            @ApiResponse(responseCode = "403", description = "Not found store and user to authorize. Access forbidden.")
    })
    @GetMapping("/all")
    public ResponseEntity<StoreListDto> getAllStores(@RequestBody StoreKeeperCredentialsDto credentialsDto) {
        return ResponseEntity.ok(storeService.getAllStores(credentialsDto));
    }

    @Operation(summary = "Get my store informations")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully added store"),
            @ApiResponse(responseCode = "403", description = "Not found store and user. Access forbidden.")
    })
    @GetMapping("/my")
    public ResponseEntity<StoreDto> getMyStore(@RequestBody StoreKeeperCredentialsDto credentialsDto) {
        return ResponseEntity.ok(storeService.getMyStore(credentialsDto));
    }

    @Operation(summary = "Add a store to database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully added store"),
            @ApiResponse(responseCode = "400", description = "Not found store with that code.")
    })
    @GetMapping(value = "/{code}")
    public ResponseEntity<StoreDto> getOneStore(@PathVariable(name = "code") String code, @RequestBody StoreKeeperCredentialsDto credentialsDto) {
        log.info(credentialsDto.toString());
        return ResponseEntity.ok(storeService.getOneStore(code, credentialsDto));
    }

    @Operation(summary = "Add a storekeeper to database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully added store"),
            @ApiResponse(responseCode = "400", description = "Storekeeper with that login already exists.")
    })
    @PostMapping("/storekeeper/register")
    public ResponseEntity<String> addStorekeeper(@RequestBody StoreKeeperDto storeKeeperDto) {
        log.info(storeKeeperDto.toString());
        storeKeeperService.addStoreKeeper(storeKeeperDto);
        return ResponseEntity.ok("Ok");
    }

    @Operation(summary = "Get my info as Storekeeper")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully got info"),
            @ApiResponse(responseCode = "403", description = "Not found store and user to authorize. Access forbidden.")
    })
    @GetMapping("/storekeeper/me")
    public ResponseEntity<StoreKeeperDataDto> getMyStoreKeeperData(@RequestBody StoreKeeperCredentialsDto credentialsDto) {
        return ResponseEntity.ok(storeKeeperService.getMyInfo(credentialsDto));
    }

    @Operation(summary = "Authorize Storekeeper")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully authorized"),
            @ApiResponse(responseCode = "403", description = "Not found store and user to authorize. Access forbidden.")
    })
    @GetMapping("/storekeeper/auth")
    public ResponseEntity<String> isStoreKeeperFromStore(@RequestBody StoreKeeperCredentialsDto credentialsDto) {
        storeService.authorize(credentialsDto);
        return ResponseEntity.ok("Ok");
    }

}
