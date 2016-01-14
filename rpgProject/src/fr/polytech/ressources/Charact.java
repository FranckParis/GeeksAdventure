package fr.polytech.ressources;

import java.util.ArrayList;

/**
 *
 * @author Francky
 */
public abstract class Charact {
    
    //Attributes
    protected String name;
    protected int maxHP;
    protected int maxMP;
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
    
    protected Weapon weapon;
    protected Armor plackart; //plastron in french
    protected Armor helmet;
    protected Armor boots;
    protected Armor trousers;
    protected Armor gauntlet;
    
    //Methods
    public abstract void initSkills();
    public abstract void initInventory();
    
    //Inventory - equip method
    public void equipItem(Item item) {
        if (item instanceof Armor) {
            // 0=helmet ; 1=plackart ; 2=gauntlet ; 3=trousers ; 4=boots
            Armor armor = (Armor)item;
            
            switch(armor.getArmorType()) {
                case 0:
                    if (this.helmet != null)
                        this.unequipHelmet();
                    this.helmet = armor;
                    break;
                case 1:
                    if (this.plackart != null)
                        this.unequipPlackart();
                    this.plackart = armor;
                    break;
                case 2:
                    if (this.gauntlet != null)
                        this.unequipGauntlet();
                    this.gauntlet = armor;
                    break;
                case 3:
                    if (this.trousers != null)
                        this.unequipTrousers();
                    this.trousers = armor;
                    break;
                case 4:
                    if (this.boots != null)
                        this.unequipBoots();
                    this.boots = armor;
                    break;
            }
        }
        else if (item instanceof Weapon) {
            Weapon weapon = (Weapon)item;
            if (this.weapon != null)
                this.unequipWeapon();
            this.weapon = weapon;
        }
    }
    
    // Unequip methods
    public void unequipHelmet() {
        this.helmet = null;
    }
    
    public void unequipPlackart() {
        this.plackart = null;
    }
    
    public void unequipGauntlet() {
        this.gauntlet = null;
    }
    
    public void unequipTrousers() {
        this.trousers = null;
    }
    
    public void unequipBoots() {
        this.boots = null;
    }
    
    public void unequipWeapon() {
        this.weapon = null;
    }
    
    // States
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
        removeCharState(toDelete);
    }

    public void removeCharState(ArrayList <Integer> toDelete){
        for (int i=toDelete.size(); i>=0; i--) {
            this.charStates.remove(i);
        }
    }
    
    public void resetCharact() {
        this.hp = this.maxHP;
        this.mp = this.maxMP;
        this.charStates= new ArrayList();
    }
            
    // toString
    public String inventoryToString() {
        String message = "-------Inventory-------";
        
        for(int i=0; i<this.getInventory().size(); i++) {
            message += "\nItem n°" + i + " - ";
            message += this.getInventory().get(i).toString();
        }
        
        return message;
    }
    
    // getters
    public int getTotalArmor() {
        return this.getArmorClass() + this.getArmorBuff() + 
                this.getHelmet().getArmorClass() +this.getPlackart().getArmorClass() +
                this.getGauntlet().getArmorClass() +this.getTrousers().getArmorClass() +
                this.getBoots().getArmorClass();
    }
    
    public int getMaxHp() {
        return maxHP;
    }
    
    public int getMaxMp() {
        return maxMP;
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

    public int getActualWeight() {
        return helmet.getWeight() + plackart.getWeight() + gauntlet.getWeight() +
                trousers.getWeight() + boots.getWeight() + weapon.getWeight();
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
    
    public boolean isStunned(){
        boolean stunned = false;
        for(int i =0; i<charStates.size(); i++){
            if(charStates.get(i).isStunned()){
                stunned = true;
            }
        }
        return stunned;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getPlackart() {
        return plackart;
    }

    public Armor getHelmet() {
        return helmet;
    }

    public Armor getBoots() {
        return boots;
    }

    public Armor getTrousers() {
        return trousers;
    }

    public Armor getGauntlet() {
        return gauntlet;
    }
                
    public boolean isDead() {
        return (this.hp <= 0);
    }
}