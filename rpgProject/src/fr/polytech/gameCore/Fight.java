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
public class Fight extends Event {
    // Attributes
    private ArrayList<Turn> turns;
    
    private ArrayList<Charact> groupNPC;
    private ArrayList<Charact> groupPC;
    
    // Constructor
    public Fight(ArrayList<Charact> groupPC, ArrayList<Charact> groupNPC, String name, String text) {
        this.groupPC = groupPC;
        this.groupNPC = groupNPC;
        this.name = name;
        this.text = text;
        this.turns = new ArrayList();
    }
    
    // Methods
    /*public void chooseActions() {
        // turn begins
        // initialize amor buffs
        for (int i=0; i<turns.size(); i++) {
            // choose actions in a menu
            // display message if PC else random choice
        }
    }
    
    public void resolveActions() {
        // End of turn, resolve actions display message
    }
    */

    public void executeFight() {
        //uses chooseActions() and resolveTurn()
    }

}
