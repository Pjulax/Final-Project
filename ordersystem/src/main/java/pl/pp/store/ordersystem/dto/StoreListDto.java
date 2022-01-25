package pl.pp.store.ordersystem.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class StoreListDto {
    private final List<StoreDto> storeList;

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
