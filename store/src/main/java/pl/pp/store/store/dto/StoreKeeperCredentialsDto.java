package pl.pp.store.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StoreKeeperCredentialsDto {
    private String storeCode;
    private String login;
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

