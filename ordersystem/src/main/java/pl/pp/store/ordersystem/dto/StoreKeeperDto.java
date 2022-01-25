package pl.pp.store.ordersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StoreKeeperDto {
    private final String login;
    private final String password;
    private final String firstName;
    private final String lastName;
}
