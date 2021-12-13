package pl.pp.store.raporting.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.pp.store.raporting.model.Store;
import pl.pp.store.raporting.model.StoredProduct;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class StoredProductsListDto {
    private final StoreDto store;
    private final List<ProductDto> products;

    public static StoredProductsListDto fromDomain(Store store, List<StoredProduct> storedProducts){
        return new StoredProductsListDto(
                StoreDto.fromDomain(store),
                storedProducts.stream().map(ProductDto::fromDomain).collect(Collectors.toList()));
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("Object StoredProductsListDto:\n");
        stringBuilder.append(store.toString());
        for( ProductDto obj : products){
            stringBuilder.append(obj.toString());
        }
        stringBuilder.append("================== Object END =====================\n");
        return stringBuilder.toString();
    }

}
