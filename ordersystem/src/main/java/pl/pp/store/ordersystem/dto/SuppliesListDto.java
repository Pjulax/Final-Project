package pl.pp.store.ordersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.pp.store.ordersystem.model.Supply;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class SuppliesListDto {
    private final List<ListedSupplyDto> supplyDtoList;

    public static SuppliesListDto fromDomain(List<Supply> supplyList) {
        return new SuppliesListDto(supplyList.stream().map(ListedSupplyDto::fromDomain).collect(Collectors.toList()));
    }

}
