package pl.pp.store.ordersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
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
