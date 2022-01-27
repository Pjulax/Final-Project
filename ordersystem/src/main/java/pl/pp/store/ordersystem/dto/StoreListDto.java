package pl.pp.store.ordersystem.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreListDto {
    private List<StoreDto> storeList;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("StoredProductsListDto:\n");
        for (StoreDto obj : storeList) {
            stringBuilder.append(obj.toString());
        }
        stringBuilder.append("================== Object END =====================\n");
        return stringBuilder.toString();
    }
}
