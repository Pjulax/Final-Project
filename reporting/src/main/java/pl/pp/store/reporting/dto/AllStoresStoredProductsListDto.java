package pl.pp.store.reporting.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AllStoresStoredProductsListDto {
    private List<StoredProductsListDto> storesStoredProductsLists;

}
