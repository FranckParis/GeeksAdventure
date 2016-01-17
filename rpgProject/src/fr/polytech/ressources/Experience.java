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
class Experience {

    //Attributes
    int xpPoints;
    int level;
    boolean levelUp;
    
    //Constructors
    public Experience() {
        this.xpPoints = 0;
        this.level = 1;
        this.levelUp = false;
    }
    
    //Methods
    
    public void addXp (int xp){
        this.xpPoints += xp;
        if(this.xpPoints % 100 == 0){
            this.level++;
            this.levelUp = true;
        }
    }

    public int getXpPoints() {
        return xpPoints;
    }

    public int getLevel() {
        return level;
    }

    public boolean isLevelUp() {
        return levelUp;
    }

    public void setLevelUp(boolean levelUp) {
        this.levelUp = levelUp;
    }
    
    
}
