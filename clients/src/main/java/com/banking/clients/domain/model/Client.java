package com.banking.clients.domain.model;

import com.banking.clients.domain.model.vo.*;
import lombok.Getter;

@Getter
public class Client extends Person {
    private Password password;
    private Boolean status;

    public Client(PersonId id, Name name, Gender gender, Identification identification, Address address, Phone phone, Password password, Boolean status) {
        super(id, name, gender, identification, address, phone);
        this.password = password;
        this.status = status;
    }
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
