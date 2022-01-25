package pl.pp.store.reporting.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class StoredProductStoresListDto {
    private final String name;
    private final CategoryType category;
    private final String code;
    private final List<StoreProductsQuantityDto> storeProductsQuantityList;

}