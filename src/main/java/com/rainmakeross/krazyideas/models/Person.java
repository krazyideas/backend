package com.rainmakeross.krazyideas.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Person {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;
    private String email;
    private String authId;

    public Person() {
    }

    public Person(String name, String email, String authId) {
        this.name = name;
        this.email = email;
        this.authId = authId;
    }

    @Override
    public String toString() {
        return String.format(
            "User[id=%d, name='%s', email='%s, authId='%s']",
            id, name, email, authId);
    }

}
