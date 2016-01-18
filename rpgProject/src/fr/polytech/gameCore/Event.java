/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.gameCore;

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
    public void start(ArrayList<Charact> groupPC) {
        this.groupPC = groupPC;
        chooseActions();
        resolveActions();
        giveRewards();
    }
    
    public abstract void chooseActions();
    
    public abstract void resolveActions();
    
    public boolean allPCDead() {
        int nbDead = 0;
        for (int i=0; i<groupPC.size(); i++) {
            if (groupPC.get(i).getHp() < 0)
                nbDead ++; 
        }
        
        return nbDead == groupPC.size();
    }
    
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
