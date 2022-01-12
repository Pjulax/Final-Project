package pl.pp.store.reporting.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.pp.store.reporting.model.StoredProduct;

@Getter
@AllArgsConstructor
public class ProductDto {
    private final String name;
    private final String code;
    private final Long quantity;

    public static ProductDto fromDomain(StoredProduct storedProduct){
        return new ProductDto(
                storedProduct.getArticle().getName(),
                storedProduct.getArticle().getCode(),
                storedProduct.getQuantity());
    }

    @Override
    public String toString(){
        return "Object ProductDto:\n" + "name: " +
                name +
                "\ncode: " +
                code +
                "\nquantity: " +
                quantity +
                "\n================== Object END =====================\n";
    }
}
