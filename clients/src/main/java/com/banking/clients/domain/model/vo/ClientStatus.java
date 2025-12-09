package com.banking.clients.domain.model.vo;

import java.util.Arrays;

public enum ClientStatus {
    TRUE,
    FALSE;

    public static ClientStatus fromString(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Status cannot be empty");
        }

        return Arrays.stream(ClientStatus.values())
                .filter(status -> status.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid status: " + value));
    }
}
