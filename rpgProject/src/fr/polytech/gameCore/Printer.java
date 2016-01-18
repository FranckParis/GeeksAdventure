/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.gameCore;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Francky
 */
public class Printer {
    
    //Attributes
    
    //Constructor
    public Printer (){}
    
    
    //Methods    
            
    public void displayString (String s){
        String[] lines = s.split("\r\n|\r|\n");
        for(int i=0; i<lines.length; i++){
            System.out.println(lines[i]);   
        }
    }
}
