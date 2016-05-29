package com.rainmakeross.krazyideas.models;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Data
public class Vote {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

    @OneToOne
    @JoinColumn(name="ideaId")
    private Idea idea;

    protected Vote() {

    }

    public Vote(User user, Idea idea) {
        this.user = user;
        this.idea = idea;
    }

    @Override
    public String toString() {
        return String.format(
            "Vote[id=%d, user='%s', idea='%s']",
            id, user, idea);
    }
}
