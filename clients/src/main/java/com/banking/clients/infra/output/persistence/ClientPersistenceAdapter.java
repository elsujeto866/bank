package com.banking.clients.infra.output.persistence;

import com.banking.clients.domain.model.Client;
import com.banking.clients.domain.model.vo.Identification;
import com.banking.clients.domain.model.vo.PersonId;
import com.banking.clients.domain.ports.output.ClientRepositoryPort;
import com.banking.clients.infra.output.persistence.mapper.ClientPersistenceMapper;
import com.banking.clients.infra.output.persistence.repository.ClientJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Repository
@RequiredArgsConstructor
public class ClientPersistenceAdapter implements ClientRepositoryPort {

    private final ClientJpaRepository clientRepository;
    private final ClientPersistenceMapper clientMapper;

    @Override
    public Mono<Client> save(Client client) {
        return Mono.fromCallable(() -> {
            var entity = clientMapper.toEntity(client);
            var saved = clientRepository.save(entity);
            return clientMapper.toDomain(saved);
        }).subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public Mono<Client> findById(PersonId id) {
        return Mono.fromCallable(() ->
                clientRepository.findByPersonId(id.value())
        )
                .subscribeOn(Schedulers.boundedElastic())
                .flatMap(Mono::justOrEmpty)
                .map(clientMapper::toDomain);
    }

    @Override
    public Mono<Client> findByIdentification(Identification identification) {
        return Mono.fromCallable( () ->
                        clientRepository.findByIdentification(identification.value())
        )
                .subscribeOn(Schedulers.boundedElastic())
                .flatMap(Mono::justOrEmpty)
                .map(clientMapper::toDomain);
    }

    @Override
    public Flux<Client> findAll() {
        return Mono.fromCallable(clientRepository::findAll)
                .subscribeOn(Schedulers.boundedElastic())
                .flatMapMany(Flux::fromIterable)
                .map(clientMapper::toDomain);
    }

    @Override
    public Mono<Boolean> existsByIdentification(Identification identification) {
        return Mono.fromCallable( () ->
                clientRepository.existsByIdentification(identification.value())
        )
                .subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public Mono<Void> deleteById(PersonId id) {
        return Mono.fromRunnable(() -> {
            clientRepository.findByPersonId(id.value())
                    .ifPresent(entity -> {
                        entity.setStatus(false);
                        clientRepository.save(entity);
                    });
        })
                .subscribeOn(Schedulers.boundedElastic())
                .then();
    }
}
