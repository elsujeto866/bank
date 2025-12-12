package com.banking.clients.infra.output.persistence.repository;

import com.banking.clients.infra.output.persistence.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientJpaRepository extends JpaRepository<ClientEntity, Long> {
    Optional<ClientEntity> findByIdentification(String identification);
    Optional<ClientEntity> findByPersonId(UUID personId);
    boolean existsByIdentification(String identification);

}
