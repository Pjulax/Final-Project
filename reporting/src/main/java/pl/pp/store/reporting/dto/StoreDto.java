package pl.pp.store.reporting.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StoreDto {
    private String name;
    private String localization;
    private String code;

    @Override
    public String toString() {
        return name + ";" + localization + ";" + code + "\n";
    }

}
