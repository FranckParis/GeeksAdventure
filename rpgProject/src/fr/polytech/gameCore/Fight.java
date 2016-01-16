/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.gameCore;

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
            String text, ArrayList<Item> loot) {
        this.groupPC = groupPC;
        this.groupNPC = groupNPC;
        this.name = name;
        this.text = text;
        this.loot = loot;
    }
    
    // Methods
    @Override
    public void chooseActions() {
        // turn begins
        while(!allPCDead()) {
            this.turn = new Turn(groupPC, groupNPC);
            turn.start();
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

}
