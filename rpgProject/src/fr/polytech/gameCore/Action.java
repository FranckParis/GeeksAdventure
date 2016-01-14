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
    private Charact character;
    private Skill skill;
    
    // Constructor
    public Action(Charact character, Skill skill) {
        this.character = character;
        this.skill = skill;
    }
    
    // Methods
    
    
    // Getters
    public Charact getCharact() {
        return character;
    }

    public Skill getSkill() {
        return skill;
    }
    
}
