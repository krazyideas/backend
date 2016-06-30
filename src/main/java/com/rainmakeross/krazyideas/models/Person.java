package com.rainmakeross.krazyideas.models;

import lombok.Data;

import java.util.List;
import javax.persistence.*;

@Entity
@Data
public class Person {

    @Id
    @SequenceGenerator(name="person_seq", sequenceName="person_id_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="person_seq")
    private long id;
    private String name;
    private String email;
    private String authId;

    @OneToMany
    @JoinColumn(name="personId")
    private List<Vote> votes;

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
