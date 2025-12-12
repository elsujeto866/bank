package com.banking.clients.infra.output.persistence;

import com.banking.clients.domain.model.Client;
import com.banking.clients.domain.model.vo.Identification;
import com.banking.clients.domain.model.vo.PersonId;
import com.banking.clients.infra.output.persistence.entity.ClientEntity;
import com.banking.clients.infra.output.persistence.mapper.ClientPersistenceMapper;
import com.banking.clients.infra.output.persistence.repository.ClientJpaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.test.StepVerifier;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClientPersistenceAdapterTest {

    @Mock
    private ClientJpaRepository clientRepository;
    @Mock
    private ClientPersistenceMapper clientMapper;
    @InjectMocks
    private ClientPersistenceAdapter adapter;


    @Test
    @DisplayName("Save should return client when successful")
    void save() {
        Client client = Client.builder()
                .id(new PersonId(UUID.randomUUID()))
                .identification(new Identification("1234567890"))
                .status(true)
                .build();
        ClientEntity entity = new ClientEntity();
        ClientEntity savedEntity = new ClientEntity();

        when(clientMapper.toEntity(client)).thenReturn(entity);
        when(clientRepository.save(entity)).thenReturn(savedEntity);
        when(clientMapper.toDomain(savedEntity)).thenReturn(client);

        StepVerifier.create(adapter.save(client))
                .expectNext(client)
                .verifyComplete();
    }

    @Test
    @DisplayName("FindById should return client when exists")
    void findById() {
        UUID uuid = UUID.randomUUID();
        PersonId id = new PersonId(uuid);
        ClientEntity entity = new ClientEntity();
        Client client = mock(Client.class);

        when(clientRepository.findByPersonId(uuid)).thenReturn(Optional.of(entity));
        when(clientMapper.toDomain(entity)).thenReturn(client);

        StepVerifier.create(adapter.findById(id))
                .expectNext(client)
                .verifyComplete();
    }

    @Test
    @DisplayName("FindById should return empty when not exists")
    void findById_Empty() {
        UUID uuid = UUID.randomUUID();
        PersonId id = new PersonId(uuid);

        when(clientRepository.findByPersonId(uuid)).thenReturn(Optional.empty());

        StepVerifier.create(adapter.findById(id))
                .verifyComplete();
    }

    @Test
    @DisplayName("FindAll should return flux of clients")
    void findAll() {
        ClientEntity entity = new ClientEntity();
        Client client = mock(Client.class);
        List<ClientEntity> list = List.of(entity, entity);

        when(clientRepository.findAll()).thenReturn(list);
        when(clientMapper.toDomain(entity)).thenReturn(client);

        StepVerifier.create(adapter.findAll())
                .expectNext(client, client)
                .verifyComplete();
    }

    @Test
    @DisplayName("DeleteById should soft delete client")
    void deleteById() {
        UUID uuid = UUID.randomUUID();
        PersonId id = new PersonId(uuid);
        ClientEntity entity = new ClientEntity();
        entity.setStatus(true);

        when(clientRepository.findByPersonId(uuid)).thenReturn(Optional.of(entity));

        StepVerifier.create(adapter.deleteById(id))
                .verifyComplete();

        verify(clientRepository).save(argThat(saved -> !saved.getStatus()));
    }
}