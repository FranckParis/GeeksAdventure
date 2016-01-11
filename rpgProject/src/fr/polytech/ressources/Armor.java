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
public class Armor extends Item {
    
    // Attributes
    protected int armorClass;
    // 0=helmet ; 1=plackart ; 2=gauntlet ; 3=trousers ; 4=boots
    protected int armorType;
    
    // Constructors
    
    /**
     * least detailed constructor - armor without charStates
     * @param name
     * @param armorClass
     * @param armorType
     * @param weight 
     */
    public Armor(String name, int armorClass, int armorType, int weight) {
        this(name, armorClass, armorType, weight, null);
    }
    
    /**
     * Most detailed constructor - armor with CharStates
     * @param name
     * @param armorClass
     * @param armorType
     * @param weight
     * @param charStates 
     */
    public Armor(String name, int armorClass, int armorType, int weight, 
            CharState charStates) {
        this.name = name;
        this.armorClass = armorClass;
        this.armorType = armorType;
        this.weight = weight;
        this.charStates = charStates;
    }
    
    // Methods
    
    // Getters

    public int getArmorClass() {
        return armorClass;
    }

    public int getArmorType() {
        return armorType;
    }
    
}
