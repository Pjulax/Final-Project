package pl.pp.store.raporting.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.pp.store.raporting.model.Store;

@Getter
@AllArgsConstructor
public class StoreDto {
    private final String name;
    private final String address;
    private final String code;

    public static StoreDto fromDomain(Store store){
        return new StoreDto(
                store.getName(),
                store.getAddress(),
                store.getCode());
    }

    @Override
    public String toString(){
        return "Object StoreDto:\n" +
                "name: " +
                name +
                "\naddress: " +
                address +
                "\ncode: " +
                code +
                "\n================== Object END =====================\n";
    }

}
