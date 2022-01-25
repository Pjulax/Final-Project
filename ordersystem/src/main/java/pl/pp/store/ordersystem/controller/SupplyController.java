package pl.pp.store.ordersystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pp.store.ordersystem.dto.StoreKeeperCredentialsDto;
import pl.pp.store.ordersystem.dto.SuppliesListDto;
import pl.pp.store.ordersystem.dto.SupplyDto;
import pl.pp.store.ordersystem.service.SupplyService;

@RestController
@RequestMapping("/product/supply")
@RequiredArgsConstructor
public class SupplyController {

    private final SupplyService supplyService;

    @PostMapping("/add")
    public ResponseEntity<String> addSupply(@RequestBody SupplyDto supplyDto) {
        supplyService.addSupply(supplyDto);
        return ResponseEntity.ok("Ok");
    }

    @PostMapping("/accept/{code}")
    public ResponseEntity<String> getMyStoreStoredProducts(@PathVariable(name = "code") String code, @RequestBody StoreKeeperCredentialsDto storeKeeperCredentialsDto) {
        supplyService.acceptSupply(code,storeKeeperCredentialsDto);
        return ResponseEntity.ok("Ok");
    }

    @GetMapping("/all")
    public ResponseEntity<SuppliesListDto> getAllSuppliesFromMyStore(@RequestBody StoreKeeperCredentialsDto storeKeeperCredentialsDto) {
        return ResponseEntity.ok(supplyService.getAllSuppliesFromMyStore(storeKeeperCredentialsDto));
    }
}