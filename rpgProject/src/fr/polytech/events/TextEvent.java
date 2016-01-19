/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.events;

import fr.polytech.gameCore.Printer;
import fr.polytech.ressources.Charact;
import java.util.ArrayList;

/**
 *
 * @author Francky
 */
public class TextEvent extends Event {
    
    //Attributes
    
    //Constructor
    public TextEvent (String text){
        this.text = text;
    }
    
    //Methods
    
    @Override
    public void start(ArrayList<Charact> groupPC){
        Printer p = new Printer();
        p.displayString(text);
    }

    @Override
    public void chooseActions() {
    }

    @Override
    public void resolveActions() {
    }
    
}
