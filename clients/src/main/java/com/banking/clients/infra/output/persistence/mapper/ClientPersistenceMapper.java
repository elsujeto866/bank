package com.banking.clients.infra.output.persistence.mapper;

import com.banking.clients.domain.model.Client;
import com.banking.clients.domain.model.vo.*;
import com.banking.clients.infra.output.persistence.entity.ClientEntity;
import org.springframework.stereotype.Component;

@Component
public class ClientPersistenceMapper {
    public ClientEntity toEntity(Client client) {
        return ClientEntity.builder()
                .personId(client.getId().value())
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
        return Client.builder()
                .id(new PersonId(clientEntity.getPersonId()))
                .name(new Name(clientEntity.getName()))
                .gender(Gender.valueOf(clientEntity.getGender().toUpperCase()))
                .identification(new Identification(clientEntity.getIdentification()))
                .address(new Address(clientEntity.getAddress()))
                .phone(new Phone(clientEntity.getPhone()))
                .password(new Password(clientEntity.getPassword()))
                .status(clientEntity.getStatus())
                .build();
    }
}
