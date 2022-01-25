package pl.pp.store.ordersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StoreDto {
    private final String name;
    private final String localization;
    private final String code;

    @Override
    public String toString() {
        return name + ";" + localization + ";" + code + "\n";
    }

}
