package com.banking.clients.domain.ports.output;

import com.banking.clients.domain.model.Client;
import com.banking.clients.domain.model.vo.Identification;
import com.banking.clients.domain.model.vo.PersonId;

import java.util.List;
import java.util.Optional;

public interface ClientRepositoryPort {
    Client save(Client client);
    Optional<Client> findById(PersonId id);
    Optional<Client> findByIdentification(Identification identification);
    List<Client> findAll();
    boolean existsByIdentification(Identification identification);
    void deleteById(PersonId id);
}
