package com.banking.clients.domain.exception;

public abstract class ClientDomainException extends RuntimeException {
    protected ClientDomainException(String message) {
        super(message);
    }
}
