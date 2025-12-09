package com.banking.clients.domain.model.vo;

public record Phone(String value) {
    public Phone{
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Phone cannot be empty");
        }
        if (value.length() != 10) {
            throw new IllegalArgumentException("Phone must be 10 digits long");
        }
        if(!value.matches("[0-9]+")) {
            throw new IllegalArgumentException("Phone must contain exactly 10 digits");
        }
    }
}
