/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.gameCore;

import fr.polytech.ressources.Charact;
import fr.polytech.ressources.Skill;

/**
 *
 * @author Nicolas
 */
public class Action {
    // Attributes

    private Charact source;
    private Charact target;

    private Skill skill;
    
    
    // Constructor
    public Action(Charact source, Skill skill, Charact target) {
        this.source = source;
        this.target = target;
        this.skill = skill;
    }
    
    // Methods
    @Override
    public String toString() {
        String message = source.getName() + " utilise " + skill.getName() + ". ";
        message += "";
        if (skill.getDiceValue() != 0) {
            message += source.getName() + " inflige " + skill.getTotalDamage() + " à "
                    + target.getName() + ".";
        }
        
        return message;
    }
    
    // Getters

    public Charact getSource() {
        return source;
    }

    public Charact getTarget() {
        return target;
    }

    public Skill getSkill() {
        return skill;
    }
    
}
