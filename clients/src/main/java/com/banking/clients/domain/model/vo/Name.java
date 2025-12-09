package com.banking.clients.domain.model.vo;

public record Name(String value) {
    public Name{
        if(value == null || value.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if(value.length() < 2 || value.length() > 100) {
            throw new IllegalArgumentException("Name length must be between 2 and 100 characters");
        }
        if(!value.matches("[a-zA-Z ]+")) {
            throw new IllegalArgumentException("Name must contain only letters");
        }
    }
}
