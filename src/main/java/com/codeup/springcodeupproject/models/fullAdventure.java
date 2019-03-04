package com.codeup.springcodeupproject.models;

import java.util.List;

public class fullAdventure {
    private AdventureLog adventureLog;
    private Adventure adventure;
    private List<Adventurer> adventurer;

    public fullAdventure(){}

    public fullAdventure(AdventureLog adventureLog, Adventure adventure, List<Adventurer> adventurer){
        this.adventureLog = adventureLog;
        this.adventure = adventure;
        this.adventurer = adventurer;
    }

    public AdventureLog getAdventureLog() {
        return adventureLog;
    }

    public void setAdventureLog(AdventureLog adventureLog) {
        this.adventureLog = adventureLog;
    }

    public Adventure getAdventure() {
        return adventure;
    }

    public void setAdventure(Adventure adventure) {
        this.adventure = adventure;
    }

    public List<Adventurer> getAdventurer() {
        return adventurer;
    }

    public void setAdventurer(List<Adventurer> adventurer) {
        this.adventurer = adventurer;
    }
}
