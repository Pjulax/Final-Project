package pl.pp.store.reporting.dto;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StoreKeeperCredentialsDto {
    @Parameter(description = "Store identifier, has 6 characters.", example = "ABCD12")
    private String storeCode;
    @Parameter(description = "Storekeeper login.", example = "Storekeeper1")
    private String login;
    @Parameter(description = "Storekeeper password.", example = "password123")
    private String password;
}
