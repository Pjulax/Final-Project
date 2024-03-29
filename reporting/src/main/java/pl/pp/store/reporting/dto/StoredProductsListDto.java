package pl.pp.store.reporting.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StoredProductsListDto {
    private StoreDto store;
    private List<StoredProductDto> products;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("StoredProductsListDto:\n");
        for (StoredProductDto obj : products) {
            stringBuilder.append(obj.toString());
        }
        stringBuilder.append("================== Object END =====================\n");
        return stringBuilder.toString();
    }

}