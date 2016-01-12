/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.ressources;

/**
 *
 * @author Nicolas
 */
public class Weapon extends Item {
    
    // Attributes
    private int damageDice;
    private int nbDice;
    
    // Constructors
    /**
     * Constructor for a unique dice whithout charStates
     * @param name
     * @param damageDice
     * @param weight 
     * @param desc
     */
    public Weapon(String name, int damageDice, int weight, String desc) {
        this(name, damageDice, 1, weight, desc, null);
    }
    
    /**
     * Constructor for a unique dice with charStates
     * @param name
     * @param damageDice
     * @param weight
     * @param charstates 
     * @param desc
     */
    public Weapon(String name, int damageDice, int weight, String desc, CharState charstates) {
        this(name, damageDice, 1, weight, desc, charstates);
    }
    
    /**
     * Constructor for multiple Dices without charstates
     * @param name
     * @param damageDice
     * @param nbDice
     * @param weight 
     * @param desc
     */
    public Weapon(String name, int damageDice, int nbDice, int weight, String desc) {
        this(name, damageDice, nbDice, weight, desc, null);
    }
    
    /**
     * Most detailed constructor - Mulple Dices and CharSate
     * @param name
     * @param damageDice
     * @param nbDice
     * @param weight
     * @param charStates 
     * @param desc
     */
    public Weapon(String name, int damageDice, int nbDice, int weight, String desc,
            CharState charStates) {
        this.name = name;
        this.damageDice = damageDice;
        this.nbDice = nbDice;
        this.weight = weight;
        this.description = desc;
        this.charStates = charStates;
    }
    
    // Methods

    // Getters
    
    public int getDamageDice() {
        return damageDice;
    }

    public int getNbDice() {
        return nbDice;
    }
    
}
