/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.ressources;

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
    private CharState charState;
    
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
    }
    
   
    
    //Methods
    
    public boolean successTest(Character source) {
        // jet dé
        
        boolean success = false;
        switch(this.assocStat){
            case 0:
                success = source.getAbilityScores().abilityTestStrength();
            case 1:
                success = source.getAbilityScores().abilityTestDexterity();
            case 2:
                success = source.getAbilityScores().abilityTestIntel();
        }
       return success;
    }
    
    public void useSkillCharState (Character source, Character target){
        if(! target.isImmune()){
            if(successTest(source)){
                target.getCharStates().add(this.charState);
            }
        }  
    }
    
    public void useSkillDamage (Character source, Character target){
        if(successTest(source)){
            int damage = this.diceValue * this.nbDices + 
                    source.getWeapon().getDamageDice() * source.getWeapon().getNbDice();
            int armor = target.getTotalArmor();
            target.hp -= (damage - armor);
            source.mp -= this.mpCost;
        }
    }
}
