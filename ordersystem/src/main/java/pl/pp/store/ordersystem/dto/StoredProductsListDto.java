package pl.pp.store.ordersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.pp.store.ordersystem.model.StoredProduct;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StoredProductsListDto {
    private StoreDto store;
    private List<StoredProductDto> products;

    public static StoredProductsListDto fromDomain(StoreDto store, List<StoredProduct> storedProducts){
        return new StoredProductsListDto( store,
                storedProducts.stream().map(StoredProductDto::fromDomain).collect(Collectors.toList()));
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("StoredProductsListDto:\n");
        for( StoredProductDto obj : products){
            stringBuilder.append(obj.toString());
        }
        stringBuilder.append("================== Object END =====================\n");
        return stringBuilder.toString();
    }

}