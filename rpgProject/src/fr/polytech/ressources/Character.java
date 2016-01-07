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
    
    protected int level;
    protected int maxWeight;
    
    protected ArrayList <Integer> abilityScores;
    protected ArrayList <Skill> skills;
    protected ArrayList <Item> inventory;
    protected Experience experience;
    
    //Methods
    public abstract void initAbilityScores();
    public abstract void initSkills();
    public abstract void initInventory();
    
}
