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
abstract class Item {
    
    //Attributes
    protected int weight;
    
    protected String name;
    
    protected CharState charStates;
    
    //Methods
    
    // Getters

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public CharState getCharStates() {
        return charStates;
    }
    
    
}
