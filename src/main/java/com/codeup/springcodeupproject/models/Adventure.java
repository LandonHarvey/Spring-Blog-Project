package com.codeup.springcodeupproject.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Adventure")
public class Adventure {

    @Id @GeneratedValue
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 200)
    private String body;

    @Column(nullable = false, length = 200)
    private String imgURL;

    @Column(name = "position", nullable = false, length = 5)
    private long position = 95;

    @Column(nullable = true, length = 4)
    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    @JoinTable(
            name="adv_adventurers",
            joinColumns={@JoinColumn(name="adventure_id")},
            inverseJoinColumns={@JoinColumn(name="adventurer_id")}
    )
    private List<Adventurer> adventurerList;

    public Adventure(){}

    public Adventure(long id, String title, String body, String imgURL, List<Adventurer> adventureLog) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.imgURL = imgURL;
        this.adventurerList = adventureLog;
    }

    public Adventure(String title, String body, String imgURL) {
        this.title = title;
        this.body = body;
        this.imgURL = imgURL;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public List<Adventurer> getAdventurerList() {
        return adventurerList;
    }

    public void setAdventurerList(List<Adventurer> adventurerList) {
        this.adventurerList = adventurerList;
    }


    public long getPosition() {
        return position;
    }

    public void setPosition(long position) {
        this.position = position;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
