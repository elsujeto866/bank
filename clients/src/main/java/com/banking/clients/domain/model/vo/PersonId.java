package com.banking.clients.domain.model.vo;

public record PersonId(String value) {
    public PersonId {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("ID cannot be empty");
        }
    }
}
