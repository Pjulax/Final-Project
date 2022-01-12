package pl.pp.store.reporting.model;

public enum Role {
    ROLE_SUPPLIER("ROLE_SUPPLIER"),
    ROLE_STOREKEEPER("ROLE_STOREKEEPER");
    private final String name;

    Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
