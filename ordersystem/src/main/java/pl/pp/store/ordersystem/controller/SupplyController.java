package pl.pp.store.ordersystem.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
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

    @Operation(summary = "Add product supply to the store")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully added product supply."),
            @ApiResponse(responseCode = "400", description = "Supply with that code exists, code must be unique. / Product from that supply doesn't exist."),
            @ApiResponse(responseCode = "403", description = "Not found store and user to authorize. Access forbidden.")
    })
    @PostMapping("/add")
    public ResponseEntity<String> addSupply(@RequestBody SupplyDto supplyDto) {
        supplyService.addSupply(supplyDto);
        return ResponseEntity.ok("Ok");
    }

    @Operation(summary = "Accept the supply to store")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully provided information about stored product."),
            @ApiResponse(responseCode = "400", description = "Supply with that code doesn't exist. / Supply with that code already is accepted."),
            @ApiResponse(responseCode = "403", description = "Not found store and user to authorize. Access forbidden.")
    })
    @PostMapping("/accept/{code}")
    public ResponseEntity<String> acceptSupply(@PathVariable(name = "code") String code, @ParameterObject StoreKeeperCredentialsDto storeKeeperCredentialsDto) {
        supplyService.acceptSupply(code,storeKeeperCredentialsDto);
        return ResponseEntity.ok("Ok");
    }

    @Operation(summary = "Get all supplies information from my store")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully provided information about stored product."),
            @ApiResponse(responseCode = "403", description = "Not found store and user to authorize. Access forbidden.")
    })
    @GetMapping("/all")
    public ResponseEntity<SuppliesListDto> getAllSuppliesFromMyStore(@ParameterObject StoreKeeperCredentialsDto storeKeeperCredentialsDto) {
        return ResponseEntity.ok(supplyService.getAllSuppliesFromMyStore(storeKeeperCredentialsDto));
    }
}