package com.banking.clients.domain.exception;

public class ClientAlreadyExistsException extends ClientDomainException {
    public ClientAlreadyExistsException(String identification) {
        super("Client with identification " + identification + " already exists");
    }
}
