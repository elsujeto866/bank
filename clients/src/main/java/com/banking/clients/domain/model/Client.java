package com.banking.clients.domain.model;

import com.banking.clients.domain.model.vo.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Client extends Person {
    private Password password;
    private Boolean status;

    public void update(Name name, Gender gender, Address address, Phone phone) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
    }

    public void changePassword(Password newPassword) {
        this.password = newPassword;
    }

    public void activate() {
        this.status = true;
    }
    public void deactivate() {
        this.status = false;
    }



}
