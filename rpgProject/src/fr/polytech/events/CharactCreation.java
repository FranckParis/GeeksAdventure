/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.events;

import fr.polytech.gameCore.Printer;
import fr.polytech.ressources.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Francky
 */
public class CharactCreation extends Event {
    
    //Attributes
    private ArrayList<Charact> groupPC;
    
    //Constructor
    /**
     * Constructor
     */
    public CharactCreation() {
        this.name = "Création de personnages";
        this.text = "Menu de création de personnage";
    }   
    
    //Methods
    /**
     * Start the event to create 3 Characters
     * @return ArrayList<Charact> groupPC
     */
    public ArrayList<Charact> start() {
        this.groupPC = selectionMenu();
        
        return groupPC;
    }
    
    /**
     * Create a menu to choose character names and class
     * @return ArrayList<Charact> groupPC
     */
    public ArrayList<Charact> selectionMenu(){
        
        ArrayList<Charact> charList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Printer p = new Printer();
        
        p.displayString("Création de l'équipe :\n");
        
        for(int i = 0; i<3; i++){
            int nb = i + 1;
            p.displayString("\nPersonnage " + nb + "\n");
            p.displayString("Entrer le nom du personnage : ");
            String name = sc.nextLine();
            p.displayString("Choisir votre classe :\n"
                    + "1 : Nooby - Courageux et fier guerrier geek (Lien connexe - 'Leeroy Jenkins')\n"
                    + "    Stats de départ : 150HP 50MP\n"
                    + "2 : Troll - Lâche et mesquin voleur (travaille à la FNAC)\n"
                    + "    Stats de départ : 120HP 80MP\n"
                    + "3 : TryHarder - Puissant et intelligent mage (2.21 Gigowatts de puissance)\n"
                    + "    Stats de départ : 75HP 150MP\n");
            try{
                int classChoice = Integer.parseInt(sc.nextLine());
            
                switch(classChoice) {
                    case 1:
                        Nooby nooby = new Nooby(i);
                        charList.add(nooby);
                    break;
                    case 2:
                        Troll troll = new Troll(name, i);
                        charList.add(troll);
                    break;
                    case 3:
                        TryHarder tryharder = new TryHarder(name, i);
                        charList.add(tryharder);
                    break;
                }
            }
        
            catch(NumberFormatException nfe)
            {
                System.out.println("Entrer un nombre");
            }
        }
        return charList;
    }

    @Override
    public void chooseActions() {
    }

    @Override
    public void resolveActions() {
    }
    
}
