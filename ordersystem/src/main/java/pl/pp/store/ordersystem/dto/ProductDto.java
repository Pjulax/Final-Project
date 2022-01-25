package pl.pp.store.ordersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.pp.store.ordersystem.model.CategoryType;
import pl.pp.store.ordersystem.model.Product;

@Getter
@AllArgsConstructor
public class ProductDto {
    private final String name;
    private final CategoryType category;
    private final String code;

    public static ProductDto fromDomain(Product product) {
        return new ProductDto(product.getName(),product.getCategory(),product.getCode());
    }

    public Product toDomain() {
        return Product.builder()
                .name(name)
                .category(category)
                .code(code)
                .build();
    }
}