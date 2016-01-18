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
public class Troll extends Charact {
    
    /**
     * Standard constructor to create a Troll character
     * @param name 
     */
    public Troll(String name, int pos){
        this.name = name;
        this.maxHP = this.hp = 120;
        this.maxMP = this.mp = 80;
        this.position = pos;
        
        this.experience = new Experience();
        
        this.abilityScores = new AbilityScores(20, 50, 30);
        this.charStates = new ArrayList();
        initSkills();
        initInventory();
    }


    @Override
    public void initSkills() {
        
        skills = new ArrayList<>();
        
        //Primary skills
        this.skills.add(new Skill ("La Patate", 6, 2, 0, 0 ));
        this.skills.add(new Skill ("La Parade", 0, 0, 0, new CharState("Parade", 5)));
                
        //Specific skills
        this.skills.add(new Skill ("Backstab", 35, 10, 0));
        this.skills.add(new Skill ("Bleed", 15, 1, 15, 0, new CharState("Saignement", 7, 0, 5)));
        this.skills.add(new Skill ("Combo-kill", 10, 7, 45, 0));
    }

    @Override
    public void initInventory() {
        this.inventory = new ArrayList<>();
        
        this.inventory = new ArrayList<>();
        
        Armor skullBandana = new Armor("Bandana à crâne",1,0,1,"I KILL YOU!");
        this.inventory.add(skullBandana);
        
        Armor capeTropDark = new Armor("Cape trop dark",3,1,3,"Incognito.");
        this.inventory.add(capeTropDark);
        
        Armor shabbyMittens = new Armor("Mittens miteuses",1,2,1,"+1 pour tenir son arme.");
        this.inventory.add(shabbyMittens);
        
        Armor oldJeans = new Armor("Jeans troués",2,3,2,"Un classique.");
        this.inventory.add(oldJeans);
        
        Armor oldBaskets = new Armor("Vieilles baskets",2,4,2,"Elle prennent l'eau.");
        this.inventory.add(oldBaskets);
        
        Weapon tableStick = new Weapon("Pied de table",6,4,2,"Ne coupe pas. Mais tabasse sévère");
        this.inventory.add(oldBaskets);
        
    }

    @Override
    public int getMaxHp() {
        return this.getHp() + this.abilityScores.getStrength() - 20;
    }

    @Override
    public int getMaxMp() {
        return this.getMp() + this.abilityScores.getIntel() - 30;
    }
}
