package com.rainmakeross.krazyideas.models;

import lombok.Data;
import org.hibernate.annotations.Formula;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
@Data
public class Idea {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    private String shortDescription;

    @Formula("(select count(*) from vote v where v.idea_Id = id)")
    private int voteCount;

    // this is anther option to calculate voteCount
    /*private transient int voteCount;

    public int getVoteCount(){
        if (votes==null) {
            return 0;
        }
        return votes.size();
    }*/

    @OneToMany
    @JoinColumn(name="ideaId")
    private List<Vote> votes;

    public Idea() {
    }

    public Idea(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format(
            "Idea[id=%d, name='%s', description='%s']",
            id, name, description);
    }

}
