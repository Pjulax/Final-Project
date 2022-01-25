package pl.pp.store.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pl.pp.store.store.model.StoreKeeper;

@Data
@AllArgsConstructor
public class StoreKeeperDto {
    private String login;
    private String password;
    private String firstName;
    private String lastName;

    public static StoreKeeperDto fromDomain(StoreKeeper storeKeeper) {
        return new StoreKeeperDto(
                storeKeeper.getLogin(),
                storeKeeper.getPassword(),
                storeKeeper.getFirstName(),
                storeKeeper.getLastName()
        );
    }

    public StoreKeeper toDomain() {
        return StoreKeeper.builder()
                .login(this.login)
                .password(this.password)
                .firstName(this.firstName)
                .lastName(this.lastName)
                .build();
    }

    @Override
    public String toString() {
        return "StoreKeeperDto{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
