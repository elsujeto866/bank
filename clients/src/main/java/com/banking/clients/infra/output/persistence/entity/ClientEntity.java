package com.banking.clients.infra.output.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "clients")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @EqualsAndHashCode.Include
    private String personId;

    @ToString.Exclude
    private String password;
    private Boolean status;

    private String name;
    private String gender;
    private String identification;
    private String address;
    private String phone;

    @PrePersist
    public void prePersist() {
        if (this.personId == null) {
            this.personId = java.util.UUID.randomUUID().toString();
        }
    }
}
