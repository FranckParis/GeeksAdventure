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
    public Turn(ArrayList<Charact> PC, ArrayList<Charact> NPC) {
        this.groupNPC = NPC;
        this.groupPC = PC;
        this.actions = new ArrayList();
        
    }
    
    // Methods
    
    public void start(int nb) {
        this.nbTurn = nb;
        initArmorBuff();
        displayNbTurn();
        chooseActions();
        resolveTurn();
    }
    
    public void initArmorBuff() {
        for (int i=0; i<groupPC.size(); i++) {
            groupPC.get(i).setArmorBuff(0);
        }
    }
    
    public void displayNbTurn() {
        Printer p = new Printer();
        String string = "\n----------------------------------------------------\n"
                      + "-------------------- Tour " + nbTurn + "-------------------------\n"
                      + "----------------------------------------------------";
        p.displayString(string);
    }
    
    private void chooseActions() {
        for (int i=0; i<groupPC.size(); i++) {
            Charact charact = groupPC.get(i);
            Action action = charact.chooseAction(groupPC, groupNPC);
            actions.add(action);
        }
        for (int i=0; i<groupNPC.size(); i++) {
            Monster monster = (Monster)groupNPC.get(i);
            actions.add(monster.chooseAction(groupPC, groupNPC));
        }
    }
    
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
