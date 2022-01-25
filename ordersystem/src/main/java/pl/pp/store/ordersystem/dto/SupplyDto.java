package pl.pp.store.ordersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.pp.store.ordersystem.model.Product;
import pl.pp.store.ordersystem.model.Supply;

import java.sql.Date;

@Getter
@AllArgsConstructor
public class SupplyDto {
    private final String code;
    private final String productCode;
    private final Long quantity;
    private final String targetStoreCode;
    private final Date arrivalDate;

    public Supply toDomain(Product product) {
        return Supply.builder()
                .code(code)
                .product(product)
                .quantity(quantity)
                .targetStoreCode(targetStoreCode)
                .arrivalDate(arrivalDate)
                .isAccepted(false)
                .build();
    }
}
