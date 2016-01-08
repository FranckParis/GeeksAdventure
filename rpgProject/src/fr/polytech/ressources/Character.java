package fr.polytech.ressources;

import java.util.ArrayList;

/**
 *
 * @author Francky
 */
public abstract class Character {
    
    //Attributes
    protected String name;
    protected int hp;
    protected int mp;
    protected int armorClass;
    protected int armorBuff;
    
    protected int level;
    protected int maxWeight;
    
    protected AbilityScores abilityScores;
    protected ArrayList <Skill> skills;
    protected ArrayList <Item> inventory;
    protected Experience experience;
    protected ArrayList<CharState> charStates;
    
    //Methods
    public abstract void initSkills();
    public abstract void initInventory();
    
    public void applyCharStates(){
        ArrayList <Integer> toDelete = new ArrayList();
        
        for(int i = 0; i<charStates.size(); i++){
            if (charStates.get(i).charStateIsOver()){
                toDelete.add(i);
            }
            else{
                this.charStates.get(i).decrementNbTurns();
                this.hp -= charStates.get(i).getHpVal();
                this.mp -= charStates.get(i).getMpVal();
                this.armorBuff += charStates.get(i).getArmorVal();
            }
            
        }
        removeCharState();
    }

    public void removeCharState(){
        
    }
    
    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getMp() {
        return mp;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public int getLevel() {
        return level;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public AbilityScores getAbilityScores() {
        return abilityScores;
    }

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public Experience getExperience() {
        return experience;
    }

    public ArrayList<CharState> getCharStates() {
        return charStates;
    }

    public int getArmorBuff() {
        return armorBuff;
    }
    
    public boolean isImmune(){
        boolean immune = false;
        for(int i =0; i<charStates.size(); i++){
            if(charStates.get(i).isImmune()){
                immune = true;
            }
        }
        return immune;
    }
    
}
