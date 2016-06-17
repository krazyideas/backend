package com.rainmakeross.krazyideas.models;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Vote {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "personId")
    private Person person;

    @ManyToOne
    @JoinColumn(name="ideaId")
    private Idea idea;

    public Vote(){

    }

    public Vote(Person person, Idea idea) {
        this.person = person;
        this.idea = idea;
    }

    @Override
    public String toString() {
        return String.format(
            "Vote[id=%d, user='%s', idea='%s']",
            id, person, idea);
    }
}
