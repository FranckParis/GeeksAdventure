/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.gameCore;

import fr.polytech.ressources.Charact;
import fr.polytech.ressources.Monster;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Thomas
 */
public class Turn {
    // Attributes
    private int nbTurn;
    private ArrayList<Action> actions;
    
    private ArrayList<Charact> groupNPC;
    private ArrayList<Charact> groupPC;
    
    // Constructor
    /**
     * 
     * @param PC
     * @param NPC 
     */
    public Turn(ArrayList<Charact> PC, ArrayList<Charact> NPC) {
        this.groupNPC = NPC;
        this.groupPC = PC;
        this.actions = new ArrayList();
        
    }
    
    // Methods
    /**
     * Start the turn
     * @param nb 
     */
    public void start(int nb) {
        this.nbTurn = nb;
        initArmorBuff();
        displayNbTurn();
        chooseActions();
        resolveTurn();
    }
    
    /**
     * Set the armor buff of all PC and NPC to 0
     */
    public void initArmorBuff() {
        for (int i=0; i<groupPC.size(); i++) {
            groupPC.get(i).setArmorBuff(0);
        }
        for (int i=0; i<groupNPC.size(); i++) {
            groupNPC.get(i).setArmorBuff(0);
        }
    }
    
    /**
     * Display actual number of turns
     */
    public void displayNbTurn() {
        Printer p = new Printer();
        String string = "\n----------------------------------------------------\n"
                      + "-------------------- Tour " + nbTurn + "-------------------------\n"
                      + "----------------------------------------------------";
        p.displayString(string);
    }
    
    /**
     * Make the PC and NPC choose thair actions
     */
    private void chooseActions() {
        for (int i=0; i<groupPC.size(); i++) {
            Charact charact = groupPC.get(i);
            if (!charact.isDead()) {
                Action action = charact.chooseAction(groupPC, groupNPC);
                actions.add(action);
            }
        }
        for (int i=0; i<groupNPC.size(); i++) {
            Monster monster = (Monster)groupNPC.get(i);
            if (!monster.isDead())
                actions.add(monster.chooseAction(groupPC, groupNPC));
        }
    }
    
    /**
     * Resolve all actions made this turn
     */
    private void resolveTurn() {
        Printer p = new Printer();
        p.displayString("\nRecap du tour");
        for (int i = 0; i<this.actions.size(); i++) {
            this.actions.get(i).getSkill().useSkillCharState(this.actions.get(i).getSource(),
                    this.actions.get(i).getTarget());
        }
        for (int i = 0; i<this.groupPC.size(); i++) {
            this.groupPC.get(i).applyCharStates();            
        }
        for (int i = 0; i<this.groupNPC.size(); i++) {
            this.groupNPC.get(i).applyCharStates();            
        }
        for (int i = 0; i<this.actions.size(); i++) {
            this.actions.get(i).getSkill().useSkillDamage(this.actions.get(i).getSource()
                    , this.actions.get(i).getTarget());
            
            String action = actions.get(i).toString();
            p.displayString(action);
        }
    }
}
