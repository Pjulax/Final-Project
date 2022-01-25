package pl.pp.store.ordersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.pp.store.ordersystem.model.StoredProduct;

@Getter
@AllArgsConstructor
public class StoredProductDto {
    private final String name;
    private final String code;
    private final Long quantity;


    public static StoredProductDto fromDomain(StoredProduct storedProduct) {
        return new StoredProductDto(
                storedProduct.getProduct().getName(),
                storedProduct.getProduct().getCode(),
                storedProduct.getQuantity());
    }

    @Override
    public String toString() {
        return name + ";" + code + ";" + quantity + "\n";
    }
}
