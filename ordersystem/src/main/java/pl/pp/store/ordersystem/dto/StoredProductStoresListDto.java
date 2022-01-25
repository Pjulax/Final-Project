package pl.pp.store.ordersystem.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.pp.store.ordersystem.model.CategoryType;
import pl.pp.store.ordersystem.model.StoredProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class StoredProductStoresListDto {
    private final String name;
    private final CategoryType category;
    private final String code;
    private final List<StoreProductsQuantityDto> storeProductsQuantityList;

    public static StoredProductStoresListDto fromDomain(Map<String, StoreDto> storeDtos, Map<String, StoredProduct> storedProducts) {
        String[] storeKeys = storedProducts.keySet().toArray(String[]::new);
        List<StoreProductsQuantityDto> storeProductsQuantityList = new ArrayList<>();
        for (String storeKey : storeKeys) {
            if(storedProducts.get(storeKey) != null)
                storeProductsQuantityList.add(new StoreProductsQuantityDto(storeDtos.get(storeKey).getName(), storeDtos.get(storeKey).getCode(), storedProducts.get(storeKey).getQuantity()));
            storeProductsQuantityList.add(new StoreProductsQuantityDto(storeDtos.get(storeKey).getName(), storeDtos.get(storeKey).getCode(), 0L));
        }
        return new StoredProductStoresListDto(
                storedProducts.get(storeKeys[0]).getProduct().getName(),
                storedProducts.get(storeKeys[0]).getProduct().getCategory(),
                storedProducts.get(storeKeys[0]).getProduct().getCode(),
                storeProductsQuantityList
        );

    }

}