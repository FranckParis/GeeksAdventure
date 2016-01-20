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
public class TryHarder extends Charact {
    
    /**
     * Standard constructor to create a TryHarder character
     * @param name 
     * @param pos in groupPC
     */
    public TryHarder(String name, int pos){
        this.name = name;
        this.hp = 75;
        this.mp = 150;
        this.position = pos;
        
        this.experience = new Experience();
        this.charStates = new ArrayList<>();
        
        this.abilityScores = new AbilityScores(10, 20, 70);
        
        initSkills();
        initInventory();
    }


    /**
     * Initialize all skills
     */
    @Override
    public void initSkills() {
        skills = new ArrayList<>();
        
        //Primary skills
        this.skills.add(new Skill ("Le retour du baton !", 10, 2, 0, 2));
        this.skills.add(new Skill ("La Parade", 0, 0, 2, new CharState("Parade", 4)));
                
        //Specific skills
        this.skills.add(new Skill ("Boule de feu des familles", 10, 3, 15, 2));
        this.skills.add(new Skill ("Heal des familles", -10, 2, 20, 2));
        this.skills.add(new Skill ("Pression extra-orbital", 8, 2, 20, 2, new CharState("Pression extra-orbital", 8, 0, 4)));
        this.skills.add(new Skill ("J'carry la game gros", 20, 4, 42, 2));
    }

    /**
     * Initialize all Items
     */
    @Override
    public void initInventory() {
        this.inventory = new ArrayList<>();
        
        Armor helmet = new Armor("Casque Turtle Beach 7.1",1,0,1,"Casque utilisé par des champions de Starcraft");
        this.inventory.add(helmet);
        
        Armor plackart = new Armor("Chemise propre",1,1,1,"Chemise propre toute blanche, parfaite pour les streams");
        this.inventory.add(plackart);
        
        Armor gauntlets = new Armor("Rien",0,2,0,"Nope, rien");
        this.inventory.add(gauntlets);
        
        Armor trousers = new Armor("Jean propre",1,3,2,"Jean bien propre, parfait pour les longs try de raid");
        this.inventory.add(trousers);
        
        Armor boots = new Armor("Chaussettes sales",0,4,3,"C'est le poids de la culpabilité");
        this.inventory.add(boots);
        
        Weapon weapon = new Weapon("Brindille de bois",6,2,2,"VOUS NE PASSEREZ ... non .. attendez ..");
        this.inventory.add(weapon);
    }
    
    @Override
    public int getMaxHp() {
        return this.getHp() + this.abilityScores.getStrength() - 10;
    }

    @Override
    public int getMaxMp() {
        return this.getMp() + this.abilityScores.getIntel() - 70;
    }
}
