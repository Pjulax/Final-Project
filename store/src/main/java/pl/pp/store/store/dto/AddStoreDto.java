package pl.pp.store.store.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.pp.store.store.model.Store;

@Getter
@AllArgsConstructor
public class AddStoreDto {
    private final String name;
    private final String localization;
    private final String code;
    private final String storekeeperLogin;

    public Store toDomain() {
        return Store.builder()
                .name(this.name)
                .localization(this.localization)
                .code(this.code)
                .build();
    }

    @Override
    public String toString() {
        return name + ";" + localization + ";" + code + ";" + storekeeperLogin + "\n";
    }

}
