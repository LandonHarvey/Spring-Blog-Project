package com.codeup.springcodeupproject.models;

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

    public Adventure(){}

    public Adventure(long id, String title, String body, String imgURL) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.imgURL = imgURL;
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

}
