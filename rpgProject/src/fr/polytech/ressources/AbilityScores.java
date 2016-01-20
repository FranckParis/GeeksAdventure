/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.ressources;

import me.grea.antoine.utils.Dice;

/**
 *
 * @author Francky
 */
public class AbilityScores {
    
    //Attributes
    private int strength;
    private int dex;
    private int intel;
    
    //Constructors
    /**
     * 
     * @param s strength
     * @param d dexterity
     * @param i intelligence
     */
    public AbilityScores(int s, int d, int i){
        this.strength = s;
        this.dex = d;
        this.intel = i;
    }
    
    //Methods

    public int getStrength() {
        return strength;
    }

    public int getDex() {
        return dex;
    }

    public int getIntel() {
        return intel;
    }
    
    /**
     * Test dice throw
     * @return bool
     */
    public boolean abilityTestStrength(){
        Dice d = new Dice();
        int val = d.roll(100);
        return(val < this.strength);
    }
    
    /**
     * Test dice throw
     * @return bool
     */
    public boolean abilityTestDexterity(){
        Dice d = new Dice();
        int val = d.roll(100);
        return(val < this.dex);
    }
    
    /**
     * Test dice throw
     * @return bool
     */
    public boolean abilityTestIntel(){
        Dice d = new Dice();
        int val = d.roll(100);
        return(val < this.intel);
    }
    
    /**
     * 
     * @param s 
     */
    public void increaseStrength (int s){
        this.strength += s;
    }
    
    /**
     * 
     * @param d 
     */
    public void increaseDex (int d){
        this.dex += d;
    }
    
    /**
     * 
     * @param i 
     */
    public void increaseIntel (int i){
        this.intel += i;
    }
}
