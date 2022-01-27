package pl.pp.store.ordersystem.dto;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StoreKeeperCredentialsDto {
    @Parameter(description = "Store identifier, has 6 characters.", example = "ABCD12")
    private final String storeCode;
    @Parameter(description = "Storekeeper login.", example = "Storekeeper1")
    private final String login;
    @Parameter(description = "Storekeeper password.", example = "password123")
    private final String password;
}