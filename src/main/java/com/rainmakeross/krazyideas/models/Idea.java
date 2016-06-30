package com.rainmakeross.krazyideas.models;

import lombok.Data;
import org.hibernate.annotations.Formula;

import java.util.List;
import javax.persistence.*;

@Entity
@Data
public class Idea {
    @Id
    @SequenceGenerator(name="idea_seq", sequenceName="idea_id_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="idea_seq")
    private long id;
    private String name;
    private String description;
    private String shortDescription;
    private String html;

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

    public Idea(String name, String description, String html) {
        this.name = name;
        this.description = description;
        this.html = html;
    }

    @Override
    public String toString() {
        return String.format(
            "Idea[id=%d, name='%s', description='%s']",
            id, name, description);
    }

}
