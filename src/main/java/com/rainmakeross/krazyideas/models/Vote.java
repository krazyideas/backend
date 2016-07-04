package com.rainmakeross.krazyideas.models;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Vote {
    @Id
    @SequenceGenerator(name="vote_seq", sequenceName="vote_id_seq", allocationSize=1)
    @GeneratedValue(generator="vote_seq")
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
