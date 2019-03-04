package com.codeup.springcodeupproject.models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

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
    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "adventurelog_id")
    private AdventureLog adventureLog;

    public Adventure(){}

    public Adventure(long id, String title, String body, String imgURL, AdventureLog adventureLog) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.imgURL = imgURL;
        this.adventureLog = adventureLog;
    }

    public Adventure(String title, String body, String imgURL, AdventureLog adventureLog) {
        this.title = title;
        this.body = body;
        this.imgURL = imgURL;
        this.adventureLog = adventureLog;
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

    public AdventureLog getAdventureLog() {
        return adventureLog;
    }

    public void setAdventureLog(AdventureLog adventureLog) {
        this.adventureLog = adventureLog;
    }
}
