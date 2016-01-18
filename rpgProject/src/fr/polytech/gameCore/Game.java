/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.gameCore;

import fr.polytech.persistence.Data;
import fr.polytech.ressources.Charact;
import java.util.ArrayList;
import java.util.Scanner;

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
        Scanner sc = new Scanner(System.in);
        Printer p = new Printer(); 
        
        
        p.displayString("   ______          __      ___       __                 __                      \n" +
"  / ____/__  ___  / /__   /   | ____/ /   _____  ____  / /___  __________  _____\n" +
" / / __/ _ \\/ _ \\/ //_/  / /| |/ __  / | / / _ \\/ __ \\/ __/ / / / ___/ _ \\/ ___/\n" +
"/ /_/ /  __/  __/ ,<    / ___ / /_/ /| |/ /  __/ / / / /_/ /_/ / /  /  __(__  ) \n" +
"\\____/\\___/\\___/_/|_|  /_/  |_\\__,_/ |___/\\___/_/ /_/\\__/\\__,_/_/   \\___/____/  \n" +
"                                                                                ");
  
        
        p.displayString("Bienvenue dans Geek Adventures v 0.00000001 !\n\n");
        p.displayString("Attention : Early Access - ce contenu ne constitue pas la version finale du jeu et n'est pas "
                + "représentatif de ses objectifs de qualité.\n");
        
        p.displayString("1 - Nouvelle partie \n"
                        + "2 - Quitter \n");
        
        int menuChoice = Integer.parseInt(sc.nextLine());
        
        switch(menuChoice) {
            case 1:
                CharactCreation charactCreation = new CharactCreation();
                groupPC = charactCreation.start();
        
                // Send groupPC to Data and get events list
                data = new Data(groupPC);
                events = data.getEvents();
        
                // others events
                for (int i=0; i<events.size(); i++) {
                    events.get(i).start(groupPC);
                }
        
                p.displayString("Fin du jeu ! Vous avez fait les courses, bravo !");
            break;
                
            case 2:
                 p.displayString("Merci d'avoir au moins lancé le jeu. Non, vraiment.");
            break;
                
            case 42:
                 p.displayString("Vous avez cru au CheatCode hein ?");
            break;
        }
    }
    
    // Getters

    public ArrayList<Charact> getGroupPC() {
        return groupPC;
    }
    
    
}
