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
     * @param desc
     */
    public Armor(String name, int armorClass, int armorType, int weight, String desc) {
        this(name, armorClass, armorType, weight, desc, null);
    }
    
    /**
     * Most detailed constructor - armor with CharStates
     * @param name
     * @param armorClass
     * @param armorType
     * @param weight
     * @param charStates 
     * @param desc
     */
    public Armor(String name, int armorClass, int armorType, int weight, String desc,
            CharState charStates) {
        this.name = name;
        this.armorClass = armorClass;
        this.armorType = armorType;
        this.weight = weight;
        this.description = desc;
        this.charStates = charStates;
    }
    
    // Methods
    
    /**
     * Display the armor type and the armor class of the armor
     * @return 
     */
    @Override
    public String toString() {
        String message = super.toString();
        message += " Armor class : " + this.armorClass + ". ";
        
        message += "Armor Type : ";
        
        switch(this.armorType) {
            case 0:
                message += "Helmet. ";
                break;
            case 1:
                message += "Plackart. ";
                break;
            case 2:
                message += "Gauntlets. ";
                break;
            case 3:
                message += "Trousers. ";
                break;
            case 4:
                message += "Boots. ";
                break;
        }
        
        message += "Effect : " + this.charStates.toString() + ". ";
        
        return message;
    }
    
    // Getters

    public int getArmorClass() {
        return armorClass;
    }

    public int getArmorType() {
        return armorType;
    }
    
}
