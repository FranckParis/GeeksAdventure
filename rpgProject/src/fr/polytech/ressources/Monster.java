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
        this.maxMP = MP;
        
        this.abilityScores = stats;
        this.skills = skills;
        this.inventory = inventory;
    }

    @Override
    public Action chooseAction(ArrayList<Charact> PC, ArrayList<Charact> NPC) {
        // Target
        Dice dice = new Dice();
        int nTarget = dice.roll(PC.size());
        Charact target = PC.get(nTarget);
        
        // Skill
        int nSkill;
        Skill skill;
        boolean enoughMana;
        do {
            nSkill = dice.roll(skills.size());
            skill = skills.get(nSkill);
            enoughMana = skill.getMpCost() <= this.getMp();
        } while(!enoughMana);
        
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
