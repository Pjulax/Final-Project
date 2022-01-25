package pl.pp.store.reporting.dto;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CategoryType {
    DAIRY("Dairy"),
    FRUITS_AND_VEGETABLES("Fruits and Vegetables"),
    MEAT("Meat"),
    GROCERY("Grocery"),
    BEVERAGES("Beverages"),
    ALCOHOL("Alcohol"),
    CLOTHING("Clothing"),
    CONFECTIONERY("Confectionery"),
    ELECTRONICS("Electornics"),
    CLEANING("Cleaning"),
    @JsonEnumDefaultValue
    UNKNOWN("Unknown");

    private final String typeName;

    CategoryType(String typeName) {
        this.typeName = typeName;
    }

    @JsonValue
    public String getTypeName() {
        return typeName;
    }
}
