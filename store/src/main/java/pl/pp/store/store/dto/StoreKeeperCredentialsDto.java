package pl.pp.store.store.dto;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.*;

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

    @Override
    public String toString() {
        return "StoreKeeperCredentialsDto{" +
                "storeCode='" + storeCode + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

