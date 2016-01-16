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
        events = data.getEvents();
        groupPC = data.getGroupPC();
    }
    
    // methods
    public void start() {
        for (int i=0; i<events.size(); i++) {
            events.get(i).start(groupPC);
        }
    }
}
