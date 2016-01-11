/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.gameCore;

import java.util.ArrayList;

/**
 *
 * @author Francky
 */
public class Fight extends Event {
    // Attributes
    private ArrayList<Turn> turns;
    
    private ArrayList<Character> groupNPC;
    private ArrayList<Character> groupPC;
    
    // Constructor
    public Fight(ArrayList<Character> groupNPC, String text) {
        //this.groupPC = 
        this.groupNPC = groupNPC;
        this.text = text;
        this.turns.add(new Turn());
    }
    
    // Methods
    public void chooseActions() {
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
}
