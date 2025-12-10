package com.banking.clients.domain.model.vo;

import java.util.UUID;

public record PersonId(UUID value) {
    public PersonId {
        if (value == null) {
            throw new IllegalArgumentException("ID cannot be empty");
        }
    }
}
