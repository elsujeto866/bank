package com.banking.clients.domain.model.vo;

import java.util.Arrays;

public enum Gender {
    MALE,
    FEMALE,
    OTHER;

    public static Gender fromString(String value) {
        if(value == null || value.isBlank()) {
            throw new IllegalArgumentException("Gender cannot be empty");
        }
        return Arrays.stream(Gender.values())
                .filter(g -> g.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid gender: " + value));

    }
}
