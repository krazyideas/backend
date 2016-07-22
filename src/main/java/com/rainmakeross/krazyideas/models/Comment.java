package com.rainmakeross.krazyideas.models;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "personId")
    private Person person;

    @ManyToOne
    @JoinColumn(name="ideaId")
    private Idea idea;

    private String content;
    private Date creationTime;
}
