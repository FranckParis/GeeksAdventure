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
public class Nooby extends Character {
    
    public Nooby(){
        this.name = "Kevin";
        this.hp = 150;
        this.mp = 50;
        
        this.level = 1;
        this.experience = new Experience(0);
        
        initAbilityScores();
        initSkills();
        initInventory();
    }

    @Override
    public void initAbilityScores() {
        //Force, Dext, Int
        this.abilityScores.add(60);
        this.abilityScores.add(30);
        this.abilityScores.add(10);
    }

    @Override
    public void initSkills() {
        this.skills.add(new Skill ("Mandale.exe", 6, 3, 0, 0));
    }

    @Override
    public void initInventory() {
        this.inventory = new ArrayList<>();
        
    }
}
