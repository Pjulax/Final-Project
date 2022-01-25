package pl.pp.store.reporting.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StoredProductDto {
    private final String name;
    private final String code;
    private final Long quantity;

    @Override
    public String toString() {
        return name + ";" + code + ";" + quantity + "\n";
    }
}
