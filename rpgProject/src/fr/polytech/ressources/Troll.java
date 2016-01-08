/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.ressources;

import java.util.ArrayList;

/**
 *
 * @author Francky
 */
public class Troll extends Character {
    
    /**
     * Standard constructor to create a Troll character
     * @param name 
     */
    public Troll(String name){
        this.name = name;
        this.hp = 120;
        this.mp = 80;
        
        this.level = 1;
        this.experience = new Experience(0);
        
        this.abilityScores = new AbilityScores(20, 50, 30);
        
        initSkills();
        initInventory();
    }


    @Override
    public void initSkills() {
        //this.skills.add(new Skill ("Mandale.exe", 6, 3, 0, 0));
    }

    @Override
    public void initInventory() {
        this.inventory = new ArrayList<>();
        
    }
}
