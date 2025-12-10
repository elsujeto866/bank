package com.banking.clients.infra.output.persistence.mapper;

import com.banking.clients.domain.model.Client;
import com.banking.clients.domain.model.vo.*;
import com.banking.clients.infra.output.persistence.entity.ClientEntity;
import org.springframework.stereotype.Component;

@Component
public class ClientPersistenceMapper {
    public ClientEntity toEntity(Client client) {
        return ClientEntity.builder()
                .personId(client.getId().toString())
                .password(client.getPassword().value())
                .status(client.getStatus())
                .name(client.getName().value())
                .identification(client.getIdentification().value())
                .gender(client.getGender().toString())
                .address(client.getAddress().value())
                .phone(client.getPhone().value())
                .build();
    }
    public Client toDomain(ClientEntity clientEntity) {
        return new Client(
                new PersonId(java.util.UUID.fromString(clientEntity.getPersonId())),
                new Name(clientEntity.getName()),
                Gender.valueOf(clientEntity.getGender().toUpperCase()),
                new Identification(clientEntity.getIdentification()),
                new Address(clientEntity.getAddress()),
                new Phone(clientEntity.getPhone()),
                new Password(clientEntity.getPassword()),
                clientEntity.getStatus()
        );
    }
}
