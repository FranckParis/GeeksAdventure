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
        
        this.abilityScores = new AbilityScores(60, 30, 10);
        initSkills();
        initInventory();
    }

    @Override
    public void initSkills() {
        
        //Primary skills
        this.skills.add(new Skill ("La Patate", 6, 2, 0, 0 ));
        this.skills.add(new Skill ("La Parade", 0, 0, 0, new CharState("Parade", 5)));
                
        //Specific skills
        this.skills.add(new Skill ("Mandale.exe", 30, 10, 0));
        this.skills.add(new Skill ("Même pas mal", 0, 0, 15, 0, new CharState("Même pas mal", 10, 3)));
        this.skills.add(new Skill ("This is SPAAAAARTA", 20, 3, 50, 0));
    }

    @Override
    public void initInventory() {
        this.inventory = new ArrayList<>();
        
        Armor chaussettesSales = new Armor("Chaussettes sales",0,5,1,"Ca puuue !!");
    }
    
    @Override
    public int getMaxHp() {
        return this.getHp() + this.abilityScores.getStrength() - 60;
    }

    @Override
    public int getMaxMp() {
        return this.getMp() + this.abilityScores.getIntel() - 10;
    }
}
