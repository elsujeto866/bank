package com.banking.clients.domain.model;

import com.banking.clients.domain.model.vo.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public abstract class Person {
    protected PersonId id;
    protected Name name;
    protected Gender gender;
    protected Identification identification;
    protected Address address;
    protected Phone phone;

}
