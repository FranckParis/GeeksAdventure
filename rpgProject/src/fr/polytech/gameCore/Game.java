/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.gameCore;

import fr.polytech.persistence.Data;
import fr.polytech.ressources.Charact;
import java.util.ArrayList;

/**
 *
 * @author Francky
 */
public class Game {
    
    // Attributes
    private ArrayList<Event> events;
    
    private ArrayList<Charact> groupPC;
    private Data data;
    
    // Constructor
    public Game() {
        
    }
    
    // methods
    public void start() {
        // The game begins here
        // Characters creation
        CharactCreation charactCreation = new CharactCreation();
        groupPC = charactCreation.start();
        
        // Send groupPC to Data and get events list
        data = new Data(groupPC);
        events = data.getEvents();
        
        // others events
        for (int i=1; i<events.size(); i++) {
            events.get(i).start(groupPC);
        }
    }
    
    // Getters

    public ArrayList<Charact> getGroupPC() {
        return groupPC;
    }
    
    
}
