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
    
    public void start() {
        initArmorBuff();
        chooseActions();
        resolveTurn();
    }
    
    public void initArmorBuff() {
        for (int i=0; i<groupPC.size(); i++) {
            groupPC.get(i).setArmorBuff(0);
        }
    }
    
    private void chooseActions() {
        for (int i=0; i<groupPC.size(); i++) {
            actions.add(groupPC.get(i).chooseAction(groupPC, groupNPC));
        }
        for (int i=0; i<groupNPC.size(); i++) {
            Monster monster = (Monster)groupNPC.get(i);
            actions.add(monster.chooseAction(groupPC, groupNPC));
        }
    }
    
    private void resolveTurn() {
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
        }
    }
}
