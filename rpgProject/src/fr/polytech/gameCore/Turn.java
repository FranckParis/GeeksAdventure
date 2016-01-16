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
        Scanner sc = new Scanner(System.in);
        Printer p = new Printer();
        int skillChoice;
        int targetChoice;
        for (int i = 0; i < this.groupPC.size(); i++) {
            if ((! this.groupPC.get(i).isDead()) && (! this.groupPC.get(i).isStunned())) {
                p.displayString("Choisir la compétence utilisée par " + this.groupPC.get(i).getName() + " :\n");
                for (int j = 0; j < this.groupPC.get(i).getSkills().size(); j++) {
                    p.displayString(Integer.toString(j+1) + " : " + this.groupPC.get(i).getSkills().get(j).getName() + "\n");
                }
                skillChoice=sc.nextInt()-1;
                
                if (this.groupPC.get(i).getSkills().get(skillChoice).getName() == "Parade") {
                    targetChoice = i;
                }
                else {
                    p.displayString("Choisir la cible de " + this.groupPC.get(i).getSkills().get(skillChoice).getName() + " utilisée par " + this.groupPC.get(i).getName() + " :\n");
                    for (int j = 0; j<this.groupPC.size(); j++) {
                        p.displayString(Integer.toString(j+1) + " : " + this.groupPC.get(j).getName() + "\n");
                    }
                    for (int j = 0; j<this.groupNPC.size(); j++) {
                        p.displayString(Integer.toString(j+1+this.groupPC.size()) + " : " + this.groupPC.get(j).getName() + "\n");
                    }
                    targetChoice = sc.nextInt()-1;
                }
                
                if (targetChoice < this.groupPC.size()) {
                    this.actions.add(new Action(this.groupPC.get(i),
                            this.groupPC.get(i).getSkills().get(skillChoice),
                            this.groupPC.get(targetChoice)));
                }
                else {
                    this.actions.add(new Action(this.groupPC.get(i),
                            this.groupPC.get(i).getSkills().get(skillChoice),
                            this.groupNPC.get(targetChoice-this.groupPC.size())));
                }
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
