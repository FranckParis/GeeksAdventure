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
public class TryHarder extends Character {
    
    /**
     * Standard constructor to create a TryHarder character
     * @param name 
     */
    public TryHarder(String name){
        this.name = name;
        this.hp = 75;
        this.mp = 150;
        
        this.level = 1;
        this.experience = new Experience(0);
        
        this.abilityScores = new AbilityScores(10, 20, 70);
        
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
