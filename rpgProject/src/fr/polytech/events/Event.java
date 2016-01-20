/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.events;

import fr.polytech.ressources.Charact;
import java.util.ArrayList;

/**
 *
 * @author Francky
 */
public abstract class Event {
    // Attributes
    protected String name;
    protected String text;
    protected int rewardXP;
    protected ArrayList<Charact> groupPC;
    
    // Methods
    /**
     * Start the event
     * @param groupPC 
     */
    public void start(ArrayList<Charact> groupPC) {
        this.groupPC = groupPC;
        chooseActions();
        resolveActions();
        giveRewards();
    }
    
    /**
     * Make the Characters choose their actions
     */
    public abstract void chooseActions();
    
    /**
     * Resolve all actions of the event
     */
    public abstract void resolveActions();
    
    /**
     * Test if all PC are dead
     * @return bool dead
     */
    public boolean allPCDead() {
        int nbDead = 0;
        for (int i=0; i<groupPC.size(); i++) {
            if (groupPC.get(i).getHp() < 0)
                nbDead ++; 
        }
        
        return nbDead == groupPC.size();
    }
    
    /**
     * Test if all NPC are dead
     * @param groupNPC
     * @return 
     */
    public boolean allNPCDead(ArrayList<Charact> groupNPC) {
        int nbDead = 0;
        for (int i=0; i<groupNPC.size(); i++) {
            if (groupNPC.get(i).getHp() <= 0)
                nbDead ++;
        }
        
        return nbDead == groupNPC.size();
    }
    
    /**
     * Distribute exp points
     */
    public void giveRewards() {
        // xp
        for (int i=0;i<groupPC.size(); i++) {
            groupPC.get(i).addXp(rewardXP);
        }
    }
    
    // Getters
    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }
}
