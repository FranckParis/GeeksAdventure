/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.ressources;

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
    
    //Constructors
    
     /**
     * Standard constructor for attack with unique damage dice
     * @param n name
     * @param d damage dice
     * @param mp mp cost
     * @param asStat stat used to make the roll
     */
    public Skill (String n, int d, int mp, int asStat){
        this(n, d, 1, 0, 0, mp, asStat);
    }
    
    /**
     * Constructor for attack with several damage dices
     * @param n name
     * @param d damage per Dice
     * @param nb number of dices
     * @param mp mp cost
     * @param asStat stat used to make the roll
     */
    public Skill (String n, int d, int nb, int mp, int asStat){
        this(n, d, nb, 0, 0, mp, asStat);
    }
 
    /**
     * Most detailed constructor
     * @param n name
     * @param d damage per dice
     * @param nb number of Dice
     * @param armor
     * @param dur duration
     * @param mp mp cost
     * @param asStat stat used to make the roll
     */
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
    
    public void useSkill(Character source, Character target) {
        // jet dé
        // réussi : return true ?
        target.armorClass += this.armorRating;
        target.hp -= (this.diceValue * this.nbDices);
        source.mp -= this.mpCost;
        // échec : return false ?
    }
}
