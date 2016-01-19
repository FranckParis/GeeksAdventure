/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.gameCore;

import fr.polytech.events.Event;
import fr.polytech.ressources.Charact;
import fr.polytech.ressources.Item;
import java.util.ArrayList;

/**
 *
 * @author Francky
 */
public class Fight extends Event {
    // Attributes
    private Turn turn;
    
    private ArrayList<Charact> groupNPC;
    
    private ArrayList<Item> loot;
    
    // Constructor
    public Fight(ArrayList<Charact> groupPC, ArrayList<Charact> groupNPC, String name,
            String text, ArrayList<Item> loot, int rewardXP) {
        this.groupPC = groupPC;
        this.groupNPC = groupNPC;
        this.name = name;
        this.text = text;
        this.loot = loot;
        this.rewardXP = rewardXP;
    }
    
    // Methods
    @Override
    public void chooseActions() {
        // turn begins
        int nbTurn = 0;
        while(!allPCDead()) {
            nbTurn ++;
            this.turn = new Turn(groupPC, groupNPC);
            turn.start(nbTurn);
        }
    }
    
    
    
    @Override
    public void resolveActions() {
        if (allPCDead()) {
            // fail
        }
        else {
            // succeed
        }
    }
    
    @Override
    public void giveRewards() {
        // xp
        super.giveRewards();
        
        // loot
        // TODO
    }

}
