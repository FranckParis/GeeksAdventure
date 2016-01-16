/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.gameCore;

import fr.polytech.ressources.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Francky
 */
public class CharactCreation extends Event {
    
    //Attributes
    //private ArrayList<Charact> characters;
    
    //Constructor
    public CharactCreation() {
        this.name = "Création de personnages";
        this.text = "Menu de création de personnage";
    }   
    
    //Methods
    
    public ArrayList<Charact> selectionMenu(){
        
        ArrayList<Charact> charList = new ArrayList<Charact>();
        Scanner sc = new Scanner(System.in);
        Printer p = new Printer();
        
        p.displayString("Création de l'équipe :\n");
        
        for(int i = 0; i<3; i++){
            p.displayString("Personnage " + i + "\n");
            p.displayString("Entrer le nom du personnage : ");
            String name = sc.nextLine();
            p.displayString("Choisir votre classe :\n "
                    + "1 : Nooby - Courageux et fier guerrier geek (Lien connexe - 'Leeroy Jenkins')\n"
                    + "2 : Troll - Lâche et mesquin voleur (travaille à la FNAC)\n"
                    + "3 : TryHarder - Puissant et intelligent mage (2.21 Gigowatts de puissance)\n");
            int classChoice = sc.nextInt();
            
            switch(classChoice) {
                case 1:
                    Nooby nooby = new Nooby();
                    charList.add(nooby);
                    break;
                case 2:
                    Troll troll = new Troll(name);
                    charList.add(troll);
                    break;
                case 3:
                    TryHarder tryharder = new TryHarder(name);
                    charList.add(tryharder);
                    break;
            }
        }
 
        return charList;
    }

    @Override
    public void chooseActions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void resolveActions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
