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
public class Consommable extends Item {
    
    // Attributes
    protected int hpRegen;
    protected int mpRegen;
    
    /**
     * Least detailed constructor - hp potions without charStates
     * @param name
     * @param hp 
     */
    public Consommable(String name, int hp) {
        this(name, hp, 0, null);
    }
    
    /**
     * intermediar constructor - hp and mp potions without charStates
     * @param name
     * @param hp
     * @param mp 
     */
    public Consommable(String name, int hp, int mp) {
        this(name, hp, mp, null);
    }
    
    /**
     * Most detailed constructor - regen hp/mp with charState
     * @param name
     * @param hp
     * @param mp
     * @param charStates 
     */
    public Consommable(String name, int hp, int mp, CharState charStates) {
        this.name = name;
        this.hpRegen = hp;
        this.mpRegen = mp;
        this.charStates = charStates;
    }
    
    // Methods
    
    // Getters

    public int getHpRegen() {
        return hpRegen;
    }

    public int getMpRegen() {
        return mpRegen;
    }
    
    
}
