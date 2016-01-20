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
public class CharState {
    
    //Attributes
    private String name;
    
    private int hpVal;
    private int mpVal;
    private int armorVal;
    private int nbTurns;
    
    private boolean stunned;
    private boolean immune;
    private boolean invisible;
    
    //Constructors 
    
    /**
     * basic attack
     * @param n
     * @param hp
     * @param mp
     * @param armv
     * @param nbT
     * @param stunned
     * @param immune
     * @param invisible 
     */
    public CharState(String n, int hp, int mp, int armv, int nbT, 
            boolean stunned, boolean immune, boolean invisible){
        this.name = n;
        this.hpVal = hp;
        this.mpVal = mp;
        this.armorVal = armv;
        this.nbTurns = nbT;
        this.stunned = stunned;
        this.immune = immune;
        this.invisible = invisible;
    }
    
    
    /**
     * Blocking
     * @param n
     * @param armv 
     */
    public CharState(String n, int armv){
        this(n, 0, 0, armv, 1, false, false, false);
    }
    
    /**
     * Armor buff, debuff
     * @param n
     * @param armv
     * @param nb 
     */
    public CharState(String n, int armv, int nb){
        this(n, 0, 0, armv, nb, false, false, false);
    }
    
    /**
     * Damage over time, heal
     * @param n
     * @param hp
     * @param mp
     * @param nb 
     */
    public CharState(String n, int hp, int mp, int nb){
        this(n, hp, mp, 0, nb, false, false, false);
    }
    
    // Methods 
    
    /**
     * Display the whole CharState
     * @return 
     */
    @Override
    public String toString() {
        String message = "";
        
        // hp
        if (this.hpVal > 0)
            message += "Hot of " + this.hpVal + " hp ";
        else if (this.hpVal < 0)
            message += "Dot of " + this.hpVal + " hp ";
        
        // mp
        if (this.mpVal > 0)
            message += "Hot of " + this.mpVal + " mp ";
        else if (this.mpVal < 0)
            message += "Dot of " + this.mpVal + " mp ";
        
        // armor
        if (this.armorVal > 0 )
            message += "Armor Buff of " + this.armorVal + " armor ";
        else if (this.armorVal < 0)
            message += "Armor Debuff of " + this.armorVal + " armor ";
        
        if (invisible)
            message += "Invisible ";
        if (immune)
            message += "Immune ";
        if (stunned)
            message += "Stun ";
        
        // turns
        message += " for " + this.nbTurns + " turns. ";
      
      return message;
    }
    
    /**
     * 
     * @return 
     */
    public boolean charStateIsOver(){
        if (nbTurns == 0){
            return true;
        }
        return false;
    }
    
    // getters
    
    public String getName() {
        return name;
    }

    public int getHpVal() {
        return hpVal;
    }

    public int getMpVal() {
        return mpVal;
    }

    public int getArmorVal() {
        return armorVal;
    }

    public int getNbTurns() {
        return nbTurns;
    }

    public boolean isStunned() {
        return stunned;
    }

    public boolean isImmune() {
        return immune;
    }

    public boolean isInvisible() {
        return invisible;
    }

    void decrementNbTurns() {
        this.nbTurns--;
    }
    
    
    
}
