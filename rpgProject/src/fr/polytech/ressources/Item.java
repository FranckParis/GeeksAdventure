/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.ressources;

/**
 *
 * @author Diab
 */
public abstract class Item {
    
    //Attributes
    protected int weight;
    
    protected String name;
    protected String description;
    
    protected CharState charStates;
    
    //Methods
    
    // Getters

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }

    public CharState getCharStates() {
        return charStates;
    }
    
    @Override
    public String toString() {
        String message = name + ". ";
        message += description + ". ";
        message += "Weight : " + this.getWeight();
        
        return message;
    }
    
}
