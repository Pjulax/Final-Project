package pl.pp.store.reporting.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class AllStoresStoredProductsListDto {
    private final List<StoredProductsListDto> storesStoredProductsLists;

}
