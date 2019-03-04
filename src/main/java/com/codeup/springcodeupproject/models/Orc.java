//package com.codeup.springcodeupproject.models;
//
//import org.hibernate.annotations.Cascade;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name="orc")
//public class Orc {
//
//    @Id
//    @GeneratedValue
//    private long id;
//    @Column(nullable = false, length = 100)
//    private String imgURL;
//    @Column(nullable = false, length = 100)
//    private long health = 100;
//    @Column(nullable = false, length = 100)
//    private long healing = 3;
//    @Column(nullable = false, length = 100)
//    private long arrows = 50;
//    @OneToOne
//    @Cascade(org.hibernate.annotations.CascadeType.ALL)
//    @JoinColumn(name = "adventurelog_id")
//    private AdventureLogModel adventureLog;
//
//    public Orc(){};
//
//    public Orc(String imgURL, long health, long healing, long arrows, AdventureLogModel adventureLog){
//        this.imgURL = imgURL;
//        this.health = health;
//        this.healing = healing;
//        this.arrows = arrows;
//        this.adventureLog = adventureLog;
//    };
//
//    public AdventureLogModel getAdventureLog() {
//        return adventureLog;
//    }
//
//    public void setAdventureLog(AdventureLogModel adventureLog) {
//        this.adventureLog = adventureLog;
//    }
//
//    public String getImgURL() {
//        return imgURL;
//    }
//
//    public void setImgURL(String imgURL) {
//        this.imgURL = imgURL;
//    }
//
//    public long getHealth() {
//        return health;
//    }
//
//    public void setHealth(long health) {
//        this.health = health;
//    }
//
//    public long getHealing() {
//        return healing;
//    }
//
//    public void setHealing(long healing) {
//        this.healing = healing;
//    }
//
//    public long getArrows() {
//        return arrows;
//    }
//
//    public void setArrows(long arrows) {
//        this.arrows = arrows;
//    }
//}
