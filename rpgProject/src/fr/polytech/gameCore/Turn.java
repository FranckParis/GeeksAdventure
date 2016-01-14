/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.gameCore;

import fr.polytech.ressources.Charact;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Thomas
 */
public class Turn {
    // Attributes
    private ArrayList<Action> actions;
    
    private ArrayList<Charact> groupNPC;
    private ArrayList<Charact> groupPC;
    
    // Constructor
    public Turn(ArrayList<Charact> NPC, ArrayList<Charact> PC) {
        this.groupNPC = NPC;
        this.groupPC = PC;
        this.actions = new ArrayList();
        
    }
    
    // Methods
    private void chooseActions() {
        Scanner sc = new Scanner(System.in);
        
        for (int i = 0; i<this.groupPC.size(); i++) {
            if ((! this.groupPC.get(i).isDead()) && (! this.groupPC.get(i).isStunned())) {
                //disp skill choices + choose
                //disp target choices + choose        
                //this.actions.add(new Action(this.groupPC.get(i),,));
            }       
        } 
        for (int i = 0; i<this.groupNPC.size(); i++) {
            if ((! this.groupNPC.get(i).isDead()) && (! this.groupNPC.get(i).isStunned())) {
                //disp skill choices + choose
                //disp target choices + choose        
                //this.actions.add(new Action(this.groupNPC.get(i),,));
            }       
        }
    }
    
    private void resolveTurn() {
        for (int i = 0; i<this.actions.size(); i++) {
            this.actions.get(i).getSkill().useSkillCharState(this.actions.get(i).getSource(), this.actions.get(i).getTarget());
        }
        for (int i = 0; i<this.groupPC.size(); i++) {
            this.groupPC.get(i).applyCharStates();            
        }
        for (int i = 0; i<this.groupNPC.size(); i++) {
            this.groupNPC.get(i).applyCharStates();            
        }
        for (int i = 0; i<this.actions.size(); i++) {
            this.actions.get(i).getSkill().useSkillDamage(this.actions.get(i).getSource(), this.actions.get(i).getTarget());
        }
    }
}
