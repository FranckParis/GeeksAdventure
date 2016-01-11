/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.gameCore;

/**
 *
 * @author Francky
 */
public abstract class Event {
    // Attributes
    protected String name;
    protected String text;
    
    // Methods
    
    // Getters
    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }
}
