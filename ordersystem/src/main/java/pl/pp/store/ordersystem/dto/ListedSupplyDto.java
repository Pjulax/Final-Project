package pl.pp.store.ordersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.pp.store.ordersystem.model.Supply;

import java.sql.Date;

@Getter
@AllArgsConstructor
public class ListedSupplyDto {
    private final String code;
    private final String productCode;
    private final String productName;
    private final Long quantity;
    private final Date arrivalDate;
    private final Boolean isAccepted;

    public static ListedSupplyDto fromDomain(Supply supply) {
        return new ListedSupplyDto(supply.getCode(), supply.getProduct().getCode(), supply.getProduct().getName(), supply.getQuantity(), supply.getArrivalDate(), supply.getIsAccepted());
    }
}
