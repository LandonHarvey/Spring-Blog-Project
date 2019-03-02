package com.codeup.springcodeupproject.models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "AdventureLog")
public class AdventureLog {

    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false, length = 5)
    private long postion = 95;
    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "adventurer_id")
    private Adventurer adventurer;
    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "adventure_id")
    private Adventure adventure;
    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "orc_id")
    private Orc orc;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPostion() {
        return postion;
    }

    public void setPostion(long postion) {
        this.postion = postion;
    }

    public Adventurer getAdventurer() {
        return adventurer;
    }

    public void setAdventurer(Adventurer adventurer) {
        this.adventurer = adventurer;
    }

    public Adventure getAdventure() {
        return adventure;
    }

    public void setAdventure(Adventure adventure) {
        this.adventure = adventure;
    }

    public Orc getOrc() {
        return orc;
    }

    public void setOrc(Orc orc) {
        this.orc = orc;
    }
}
