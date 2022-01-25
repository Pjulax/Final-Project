package pl.pp.store.ordersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.pp.store.ordersystem.model.StoredProduct;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class AllStoresStoredProductsListDto {
    private final List<StoredProductsListDto> storesStoredProductsLists;

    public static AllStoresStoredProductsListDto fromDomain(List<StoreDto> storeDtos, List<StoredProduct> storedProducts) {
        List<StoredProductsListDto> storesStoredProductsLists = new LinkedList<>();
        for(StoreDto store : storeDtos){
            storesStoredProductsLists.add( StoredProductsListDto.fromDomain(store,
                    storedProducts.stream().filter(storedProduct -> storedProduct.getStoreCode().equals(store.getCode())).collect(Collectors.toList())));
        }
        return new AllStoresStoredProductsListDto(storesStoredProductsLists);
    }
}
