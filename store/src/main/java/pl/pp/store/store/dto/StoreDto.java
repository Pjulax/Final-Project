package pl.pp.store.store.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.pp.store.store.model.Store;

@Getter
@AllArgsConstructor
public class StoreDto {
    private final String name;
    private final String localization;
    private final String code;

    public static StoreDto fromDomain(Store store) {
        return new StoreDto(
                store.getName(),
                store.getLocalization(),
                store.getCode());
    }

    public Store toDomain() {
        return Store.builder()
                .name(this.name)
                .localization(this.localization)
                .code(this.code)
                .build();
    }

    @Override
    public String toString() {
        return name + ";" + localization + ";" + code + "\n";
    }

}
