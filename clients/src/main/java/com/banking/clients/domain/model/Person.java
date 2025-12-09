package com.banking.clients.domain.model;

import com.banking.clients.domain.model.vo.*;
import lombok.Getter;

@Getter
public abstract class Person {
    protected final PersonId id;
    protected Name name;
    protected Gender gender;
    protected Identification identification;
    protected Address address;
    protected Phone phone;

    protected Person(PersonId id, Name name, Gender gender, Identification identification, Address address, Phone phone) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.identification = identification;
        this.address = address;
        this.phone = phone;
    }
}
