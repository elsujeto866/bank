package com.banking.clients.domain.exception;

public class ClientNotFoundException extends ClientDomainException {
    public ClientNotFoundException(String id) {
        super("Client with id " + id + " not found");
    }
}
