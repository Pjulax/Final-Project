package pl.pp.store.ordersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.pp.store.ordersystem.model.Product;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class ProductsListDto {
    private final List<ProductDto> productDtoList;

    public static ProductsListDto fromDomain(List<Product> products) {
        return new ProductsListDto(products.stream().map(ProductDto::fromDomain).collect(Collectors.toList()));
    }
}
