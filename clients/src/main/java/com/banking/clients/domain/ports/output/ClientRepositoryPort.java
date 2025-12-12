package com.banking.clients.domain.ports.output;

import com.banking.clients.domain.model.Client;
import com.banking.clients.domain.model.vo.Identification;
import com.banking.clients.domain.model.vo.PersonId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

public interface ClientRepositoryPort {
    Mono<Client> save(Client client);
    Mono<Client> findById(PersonId id);
    Mono<Client> findByIdentification(Identification identification);
    Flux<Client> findAll();
    Mono<Boolean> existsByIdentification(Identification identification);
    Mono<Void> deleteById(PersonId id);
}
