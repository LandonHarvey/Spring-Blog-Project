package com.codeup.springcodeupproject.models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "AdventureLog")
public class AdventureLog {

    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false, length = 5)
    private long postion = 95;

    public AdventureLog(){

    }

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

//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getBody() {
//        return body;
//    }
//
//    public void setBody(String body) {
//        this.body = body;
//    }
//
//    public String getAdvimage() {
//        return advimage;
//    }
//
//    public void setAdvimage(String advimage) {
//        this.advimage = advimage;
//    }
//
//    public String getAdvrimage() {
//        return advrimage;
//    }
//
//    public void setAdvrimage(String advrimage) {
//        this.advrimage = advrimage;
//    }
//
//    public String getAdvrname() {
//        return advrname;
//    }
//
//    public void setAdvrname(String advrname) {
//        this.advrname = advrname;
//    }
//
//    public List<Adventurer> getAdventurerList() {
//        return adventurerList;
//    }
//
//    public void setAdventurerList(List<Adventurer> adventurerList) {
//        this.adventurerList = adventurerList;
//    }
}
