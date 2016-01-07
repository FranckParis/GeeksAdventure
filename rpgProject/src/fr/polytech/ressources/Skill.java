/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.ressources;

import me.grea.antoine.utils.Dice;

/**
 *
 * @author Francky
 */
public class Skill {
    
    //Attributes
    private String name;
    private int assocStat;
    
    private int duration;
    private int nbDices;
    
    private int diceValue;
    private int armorRating;
    
    private int mpCost;
    
    private Character target;
    
    //Constructor
    
    //Attack
    public Skill (String n, int d, int nb, int mp, int asStat){
        this(n, d, nb, 0, 0, mp, asStat);
    }
    
 
    //Base constructor
    public Skill (String n, int d, int nb, int armor, int dur, int mp, int asStat){
        this.name = n;
        this.mpCost = mp;
        this.armorRating = armor;
        this.diceValue = d;
        this.duration = dur;
        this.assocStat = asStat;
        this.nbDices = nb;
    }
    
    //Methods
 
}
