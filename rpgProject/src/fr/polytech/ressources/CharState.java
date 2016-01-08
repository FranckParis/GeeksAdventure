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
class CharState {
    
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
    
    //Blocking
    public CharState(String n, int armv){
        this(n, 0, 0, armv, 1, false, false, false);
    }
    
    //Armor buff, debuff
    public CharState(String n, int armv, int nb){
        this(n, 0, 0, armv, nb, false, false, false);
    }
    
    //Damage over time, heal
    public CharState(String n, int hp, int mp, int nb){
        this(n, hp, mp, 0, nb, false, false, false);
    }

    
    //Methods 
    
    public boolean charStateIsOver(){
        if (nbTurns == 0){
            return true;
        }
        return false;
    }
    
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
