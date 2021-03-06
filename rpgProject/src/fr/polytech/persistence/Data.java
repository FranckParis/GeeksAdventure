/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.persistence;

import fr.polytech.events.TextEvent;
import fr.polytech.events.Event;
import fr.polytech.events.Fight;
import java.util.ArrayList;
import fr.polytech.ressources.AbilityScores;
import fr.polytech.ressources.Charact;
import fr.polytech.ressources.Item;
import fr.polytech.ressources.Monster;
import fr.polytech.ressources.Skill;

/**
 *
 * @author Nicolas
 */
public final class Data {
    
    // Attributes
    private ArrayList<Charact> groupPC;
    private ArrayList<Event> events;
    
    /**
     * Constructor
     * @param groupPC 
     */
    public Data(ArrayList<Charact> groupPC) {
        this.groupPC = groupPC;
        this.initEvents();
    }
    
    // Methods
    /**
     * Initialize events - called in constructor
     */
    public void initEvents() {
        // Create Events here
        events = new ArrayList<>();
        
        // Character Cration in Game Class
        
        //First Text
        initText1();
        
        // First fight
        initFight1();
        
        // Second fight
    }
    
    /**
     * Initialize first text event
     */
    public void initText1(){
        String text = groupPC.get(0).getName()
                + ", confortablement assis sur votre chaise de bureau en train "
                + "de carry à mort une partie de lol, vous essayez d'attraper le "
                + "coca à côté de vous. Mais ... Il est vide !!!\n"
                + "Vous prenez alors la décision de vous déplacer rapidement, "
                + "comme un ninja vers votre eden, le frigo.\n"
                + "En ouvrant la porte vous êtes soudain éclaboussé par un coca sauvage !"
                + " La nourriture a périmé et vous attaque furieusement !\n"
                + "POUR LA HORRDEEEE";
        TextEvent textEvent1 = new TextEvent(text);
        events.add(textEvent1);
    }
    
    /**
     * Initialize second event - 1st fight
     */
    public void initFight1() {
        ArrayList<Skill> skills1 = new ArrayList<>();
        skills1.add(new Skill("Crachat", 8, 4, 0, 1));
        
        ArrayList<Skill> skills2 = new ArrayList<>();
        skills2.add(new Skill("Chanpignons", 10, 4, 0, 2));
        
        Monster monster1 = new Monster("Coca moisi", 1, 40, 0, 
            new AbilityScores(50,50,50), skills1, null);
        Monster monster2 = new Monster("Pizza moisie", 1, 30, 0, 
            new AbilityScores(40,60,40), skills2, null);
        
        ArrayList<Charact> groupNPC = new ArrayList<>();
        groupNPC.add(monster1);
        groupNPC.add(monster2);
        
        
        
        Fight fight1 = new Fight(groupPC, groupNPC, "Frigo de la moisissure infernale", 
                "Combat du Frigo de la moisissure infernale !", null, 100);
        events.add(fight1);
    }
    
    // Getters
    public ArrayList<Event> getEvents() {
        return this.events;
    }
    
}
