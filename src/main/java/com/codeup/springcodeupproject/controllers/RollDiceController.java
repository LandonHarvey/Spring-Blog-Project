package com.codeup.springcodeupproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.annotation.WebServlet;
import java.lang.reflect.Array;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String rollDice() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{userGuess}")
    public String userNumber(@PathVariable Integer userGuess, Model model) {
        int numOfRolls = (int) Math.round((Math.floor(Math.random() * Math.floor(10)) +1));
        int[] randomNumbers = new int[numOfRolls];
        int wins = 0;
        for (int i= 0; i < randomNumbers.length; i++){
            System.out.println();
            randomNumbers[i] = (int) Math.round((Math.floor(Math.random() * Math.floor(6)) +1));
            if (randomNumbers[i] == userGuess){
                wins++;
            }
        }
        model.addAttribute("userGuess", userGuess);
        model.addAttribute("randomNumber", randomNumbers);
        model.addAttribute("rolls", numOfRolls);
        model.addAttribute("wins", "You Win: " + wins + " Times");

        return "roll-dice";
    }

}
