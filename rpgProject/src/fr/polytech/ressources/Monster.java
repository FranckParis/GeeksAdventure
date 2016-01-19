/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.ressources;

import fr.polytech.gameCore.Action;
import java.util.ArrayList;
import me.grea.antoine.utils.Dice;

/**
 *
 * @author Nicolas
 */
public class Monster extends Charact{

    public Monster(String name, int lvl, int HP, int MP, AbilityScores stats, 
            ArrayList<Skill> skills, ArrayList<Item> inventory){
        this.name = name;
        this.maxHP = HP;
        this.hp = HP;
        this.maxMP = MP;
        this.mp = mp;
        
        this.abilityScores = stats;
        this.skills = skills;
        this.inventory = inventory;
    }

    @Override
    public Action chooseAction(ArrayList<Charact> PC, ArrayList<Charact> NPC) {
        // Target
        Dice dice = new Dice();
        int nTarget;
        do { // Do while because dice can return a max number
            nTarget = dice.roll(PC.size());
        } while(nTarget == PC.size());
        Charact target = PC.get(nTarget);
        
        // Skill
        int nSkill;
        Skill skill;
        while(true) {
            nSkill = dice.roll(skills.size());
            if (nSkill != skills.size()) {
                skill = skills.get(nSkill);
                if (skill.getMpCost() <= this.getMp())
                    break;
            }
        }
        
        // Action
        Action action = new Action(this,skill,target);
        return action;
    }
    
    @Override
    public void initSkills() {
        
    }

    @Override
    public void initInventory() {
        
    }
    
}
