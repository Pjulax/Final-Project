package pl.pp.store.reporting.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StoreKeeperCredentialsDto {
    private final String storeCode;
    private final String login;
    private final String password;
}
