package pl.pp.store.store.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.pp.store.store.model.Store;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Getter
public class StoreListDto {
    private final List<StoreDto> storeList;

    public static StoreListDto fromDomain(List<Store> stores) {
        return new StoreListDto(
                stores.stream().map(StoreDto::fromDomain).collect(Collectors.toList()));
    }

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
