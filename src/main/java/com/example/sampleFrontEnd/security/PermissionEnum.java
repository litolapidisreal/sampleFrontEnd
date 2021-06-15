package com.example.sampleFrontEnd.security;

public enum PermissionEnum {
    PRODUCT_WRITE("product:write"),
    PRODUCT_READ("product:read"),
    PRODUCT_UPDATE("product:update"),
    PRODUCT_DELETE("product:delete"),
    TRANSACTION_WRITE("transaction:write"),
    TRANSACTION_READ("transaction:read"),
    TRANSACTION_UPDATE("transaction:update"),
    TRANSACTION_DELETE("transaction:delete");

    public String getPermission() {
        return permission;
    }

    private final String permission;

    PermissionEnum(String permission) {
        this.permission = permission;
    }
}
