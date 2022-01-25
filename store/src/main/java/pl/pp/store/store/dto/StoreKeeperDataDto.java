package pl.pp.store.store.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.pp.store.store.model.StoreKeeper;

@Getter
@AllArgsConstructor
public class StoreKeeperDataDto {
    private final String login;
    private final String firstName;
    private final String lastName;

    public static StoreKeeperDataDto fromDomain(StoreKeeper storeKeeper) {
        return new StoreKeeperDataDto(
                storeKeeper.getLogin(),
                storeKeeper.getFirstName(),
                storeKeeper.getLastName()
        );
    }

}
