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
public class Skill {
    
    //Attributes
    private String name;
    private int assocStat;
    private int nbDices;
    private int diceValue;
    private int mpCost;
    private int totalDamage;
    private int totalDamageWithoutArmor;
    private CharState charState;
    private boolean success;
    
    //Constructors
    
     /**
     * Standard constructor for attack skills with unique damage dice
     * @param n name
     * @param d damage dice
     * @param mp mp cost
     * @param asStat stat used to make the roll
     */
    public Skill (String n, int d, int mp, int asStat){
        this(n, d, 1, mp, asStat, null);
    }
    
    public Skill (String n, int d, int mp, int asStat, CharState charS){
        this(n, d, 1, mp, asStat, charS);
    }
    
    /**
     * Constructor for attack skills with several damage dices
     * @param n name
     * @param d damage per Dice
     * @param nb number of dices
     * @param mp mp cost
     * @param asStat stat used to make the roll
     */
    public Skill (String n, int d, int nb, int mp, int asStat){
        this(n, d, nb, mp, asStat, null);
    }
 
    /**
     * Most detailed constructor
     * @param n name
     * @param d damage per dice
     * @param nb number of Dice
     * @param mp mp cost
     * @param asStat stat used to make the roll
     */
    public Skill (String n, int d, int nb, int mp, int asStat, CharState charS){
        this.name = n;
        this.mpCost = mp;
        this.diceValue = d;
        this.assocStat = asStat;
        this.nbDices = nb;
        this.charState = charS;
        this.totalDamage = 0;
    }
    
   
    
    //Methods
    /**
     * Result of a ability dice throw
     * @param source
     * @return 
     */
    public boolean successTest(Charact source) {
        // jet dé
        boolean successTest = false;
        switch(this.assocStat){
            case 0:
                successTest = source.getAbilityScores().abilityTestStrength();
                break;
            case 1:
                successTest = source.getAbilityScores().abilityTestDexterity();
                break;
            case 2:
                successTest = source.getAbilityScores().abilityTestIntel();
                break;
        }
        this.success = successTest;
        return successTest;
    }
    
    /**
     * Apply CharState part of a skill
     * @param source
     * @param target 
     */
    public void useSkillCharState (Charact source, Charact target){
        if (this.charState != null) {
            if (!target.isImmune()){
                if (successTest(source)){
                    target.getCharStates().add(this.charState);
                }
            }
        }
    }
    
    /**
     * Apply raw damage part of a skill
     * @param source
     * @param target 
     */
    public void useSkillDamage (Charact source, Charact target){
        if(successTest(source)){
            int weaponDamage = 0;
            Weapon weapon = source.getWeapon();
            Dice dice = new Dice();
            if (weapon != null) {
                for (int i=0; i<weapon.getNbDice(); i++) {
                    weaponDamage += dice.roll(weapon.getDamageDice());
                }
            }
            
            int skillDamage = 0;
            if (this.diceValue > 0) { // damage
                for (int i=0; i<this.nbDices; i++) {
                    skillDamage += dice.roll(this.diceValue);
                }
            }
            else { // heal
                for (int i=0; i<this.nbDices; i++) {
                    skillDamage -= dice.roll(- this.diceValue);
                }
            }
            int damage = skillDamage + weaponDamage;
            this.totalDamageWithoutArmor = damage;
            int armor = target.getTotalArmor();
            
            // test negative damage
            if (damage > 0) // heals not affected by armor
            {
                if (damage - armor < 0)
                    this.totalDamage = 0;
                else
                    this.totalDamage = damage - armor;
            }
            
            target.setHp(target.getHp() - totalDamage);
            source.setMp(source.getMp() - this.mpCost);
        }
    }

    public String getName() {
        return name;
    }

    public int getAssocStat() {
        return assocStat;
    }

    public int getNbDices() {
        return nbDices;
    }

    public int getDiceValue() {
        return diceValue;
    }

    public int getMpCost() {
        return mpCost;
    }

    public CharState getCharState() {
        return charState;
    }

    public int getTotalDamage() {
        return totalDamage;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getTotalDamageWithoutArmor() {
        return totalDamageWithoutArmor;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        String message = name + " (";
        switch (assocStat) {
            case 0:
                message += "force";
                break;
            case 1:
                message += "dextérité";
                break;
            case 2:
                message += "intelligence";
                break;
        }
        message += ") : ";
        message += nbDices + "d" + diceValue + " damage. ";
        message += "Cost : " + mpCost + " mana.";
        
        if (charState != null) {
            message += " Effect : " + charState.toString();
        }
        
        return message;
    }
    
}
