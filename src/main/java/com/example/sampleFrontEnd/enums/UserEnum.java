package com.example.sampleFrontEnd.enums;

import com.google.common.collect.Sets;

import java.util.Arrays;
import java.util.Set;

import static com.example.sampleFrontEnd.enums.PermissionEnum.*;

public enum UserEnum {
    STUDENT(Sets.newHashSet(PRODUCT_READ,TRANSACTION_UPDATE,TRANSACTION_READ)),
    CLERK(Sets.newHashSet(PRODUCT_READ, TRANSACTION_READ, TRANSACTION_WRITE)),
    ADMIN(Sets.newHashSet(PRODUCT_READ,TRANSACTION_UPDATE,TRANSACTION_READ, PRODUCT_DELETE, PRODUCT_WRITE, PRODUCT_UPDATE, TRANSACTION_WRITE));


    private Set<PermissionEnum> permissionEnumSet;

    UserEnum(Set<PermissionEnum> permissionEnumSet) {
        this.permissionEnumSet = permissionEnumSet;
    }


    public static UserEnum findByAbbr(final String userType){
        return Arrays.stream(values()).filter(value -> value.name().equals(userType)).findFirst().orElse(null);
    }

}
