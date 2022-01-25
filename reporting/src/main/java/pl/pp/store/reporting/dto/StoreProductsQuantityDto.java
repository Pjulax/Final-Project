package pl.pp.store.reporting.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StoreProductsQuantityDto {
    private final String storeName;
    private final String storeCode;
    private final Long quantity;

}
