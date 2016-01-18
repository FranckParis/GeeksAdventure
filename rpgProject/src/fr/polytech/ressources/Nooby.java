/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.ressources;
import java.util.ArrayList;
/**
 *
 * @author Francky
 */
public class Nooby extends Charact {
    
    public Nooby(int pos){
        this.name = "Kevin";
        this.maxHP = this.hp = 150;
        this.maxMP = this.mp = 50;
        
        this.position = pos;
        
        this.experience = new Experience();
        this.charStates = new ArrayList<>();
        
        this.abilityScores = new AbilityScores(60, 30, 10);
        initSkills();
        initInventory();
    }

    @Override
    public void initSkills() {
        
        skills = new ArrayList<>();
        
        //Primary skills2
        this.skills.add(new Skill ("La Patate", 6, 2, 0, 0 ));
        this.skills.add(new Skill ("La Parade", 0, 0, 0, new CharState("Parade", 5)));
                
        //Specific skills
        this.skills.add(new Skill ("Mandale.exe", 30, 10, 0));
        this.skills.add(new Skill ("Même pas mal", 0, 0, 15, 0, new CharState("Même pas mal", 10, 3)));
        this.skills.add(new Skill ("This is SPAAAAARTA", 20, 3, 50, 0));
    }

    @Override
    public void initInventory() {
        this.inventory = new ArrayList<>();
        
        Armor batmanMask = new Armor("Masque de Batman",1,0,1,"Je suis la nuit.");
        this.inventory.add(batmanMask);
        
        Armor metalSweatShirt = new Armor("Sweat Shirt de Metal",3,1,3,"Parce que YEAAAAHHHHHH.");
        this.inventory.add(metalSweatShirt);
        
        Armor kitchenGloves = new Armor("Gants de cuisine",1,2,1,"Evite de se brûler. Mais c'est tout.");
        this.inventory.add(kitchenGloves);
        
        Armor oldJeans = new Armor("Jeans troués",2,3,2,"Un classique.");
        this.inventory.add(oldJeans);
        
        Armor oldBaskets = new Armor("Vieilles baskets",2,4,2,"Elle prennent l'eau.");
        this.inventory.add(oldBaskets);
        
        Weapon tableStick = new Weapon("Pied de table",6,4,2,"Ne coupe pas. Mais tabasse sévère");
        this.inventory.add(oldBaskets);
    }
}
