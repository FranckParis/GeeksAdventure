/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.persistence;

import java.util.ArrayList;
import fr.polytech.gameCore.*;
import fr.polytech.ressources.Charact;

/**
 *
 * @author Nicolas
 */
public class Data {
    
    // Attributes
    private ArrayList<Event> events;
    private ArrayList<Charact> groupPC;
    
    // Constructor
    public Data() {
        this.initEvents();
        this.initPC();
    }
    
    // Methods
    public void initEvents() {
        // Create Events here
        
        
    }
    
    public void initPC() {
        // initialize Player Characters here
    }
    
    public ArrayList<Event> getEvents() {
        
        return this.events;
    }
    
    public ArrayList<Charact> getGroupPC() {
        
        return this.groupPC;
    }
}
