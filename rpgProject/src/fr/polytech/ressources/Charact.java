package fr.polytech.ressources;

import fr.polytech.gameCore.Action;
import fr.polytech.gameCore.Printer;
import java.util.ArrayList;
import java.util.Scanner;

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
    protected int maxWeight;
    protected int position;
    
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
    
    /**
     * Inventory - Equip method
     * @param item 
     */
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
    /**
     * Apply all CharStates to the Character
     * Decrement nbTurn
     * Delete if nbTurn=0
     */
    public void applyCharStates(){
        ArrayList <CharState> toDelete = new ArrayList<>();
        
        if (!charStates.isEmpty()) {
            for(int i = 0; i<charStates.size(); i++){
                if (charStates.get(i).charStateIsOver()){
                    toDelete.add(this.charStates.get(i));
                }
                else{
                    this.charStates.get(i).decrementNbTurns();
                    this.hp -= charStates.get(i).getHpVal();
                    this.mp -= charStates.get(i).getMpVal();
                    this.armorBuff += charStates.get(i).getArmorVal();
                }

            }
            if (!toDelete.isEmpty())
                removeCharState(toDelete);
        }
    }

    /**
     * Remove all CharStates safely
     * @param toDelete 
     */
    public void removeCharState(ArrayList<CharState> toDelete){
        for (int i=toDelete.size(); i>=0; i--) {
            this.charStates.remove(toDelete.get(i));
        }
    }
    
    /**
     * method to regen the Character
     */
    public void resetCharact() {
        this.hp = this.maxHP;
        this.mp = this.maxMP;
        this.charStates= new ArrayList();
    }
    
    // Actions
    /**
     * Make the PC choose their action each turn
     * Method used ONLY to PC
     * @param groupPC
     * @param groupNPC
     * @return 
     */
    public Action chooseAction(ArrayList<Charact> groupPC, ArrayList<Charact> groupNPC) {
        Scanner sc = new Scanner(System.in);
        Printer p = new Printer();
        int skillChoice;
        int targetChoice;
        
        Action action = null;
        
        if ((!this.isDead()) && (!this.isStunned())) {
            p.displayString("Choisir la compétence utilisée par " + this.getName() 
                    + " :\n");
            for (int j = 0; j < this.getSkills().size(); j++) {
                p.displayString(Integer.toString(j+1) + " : " + 
                        this.getSkills().get(j).getName() + "\n");
            }
            skillChoice=sc.nextInt()-1;

            if (this.getSkills().get(skillChoice).getName().equals("Parade")) {
                targetChoice = this.getPosition();
            }
            else {
                p.displayString("Choisir la cible de " + 
                        this.getSkills().get(skillChoice).getName() + 
                        " utilisée par " + this.getName() + " :\n");
                        p.displayString(groupToString(groupPC, 0));
                        p.displayString(groupToString(groupNPC, groupPC.size()));
                targetChoice = sc.nextInt();
            }

            if (targetChoice < groupPC.size()) {
                action = new Action(this,
                        this.getSkills().get(skillChoice),
                        groupPC.get(targetChoice));
            }
            else {
                action = new Action(this,
                        this.getSkills().get(skillChoice),
                        groupNPC.get(targetChoice-groupPC.size()));
            }
        }
        
        return action;
    }
            
    // toString
    /**
     * Display inventory
     * @return 
     */
    public String inventoryToString() {
        String message = "-------Inventory-------";
        
        for(int i=0; i<this.getInventory().size(); i++) {
            message += "\nItem n°" + i + " - ";
            message += this.getInventory().get(i).toString();
        }
        
        return message;
    }
    
    // toString
    /**
     * Display group
     * First index needed. 0 if PC 3 if NPC
     * @param group
     * @param firstIndex
     * @return 
     */
    public String groupToString(ArrayList<Charact> group, int firstIndex) {
        String message = "";
        
        int nb;
        for (int i=0; i<group.size(); i++) {
            nb = firstIndex + i;
            String state;
            if (group.get(i).getHp() <= 0)
                state = "  Dead ! BIIIM !\n";
            else
                state = group.get(i).getHp() + "/"
                    + group.get(i).getMaxHp() + " hp   " + group.get(i).getMp() + 
                    "/" + group.get(i).getMaxMp() + " mp\n";
                
            message += nb + " - " + group.get(i).getName() + " - " + state;
        }
        
        return message;
    }
    
    /**
     * Display all skills
     * @return 
     */
    public String skillsToString() {
        String message = "-------Skills-------";
        
        for(int i=0; i<this.getSkills().size(); i++) {
            message += "\nSkill n°" + i + " - ";
            message += this.getSkills().get(i).toString();
        }
        
        return message;
    }
    
    // Experience
    public void addXp (int xp){
        this.experience.addXp(xp);
    }
    
    public void checkLevelUp(){
        Printer p = new Printer();
        Scanner sc = new Scanner(System.in);
        int pointsToSpend = 30;
        
        if(this.getExperience().isLevelUp()){
            p.displayString("Féllicitations ! " + this.name +" a gagné un niveau !");
            
            while(pointsToSpend > 0){
                 
                p.displayString("Répartir vos 30 points de caractéristiques : "+ pointsToSpend + " points restants\n "
                        + "1 : Force\n"
                        + "2 : Dextérité\n"
                        + "3 : Intelligence\n");
                try{
                    int abilityChoice = Integer.parseInt(sc.nextLine());
            
                    switch(abilityChoice) {
                        case 1:
                            p.displayString("Combien de points en Force ? "+ pointsToSpend + " points restants.");
                            int numberChoiceStr = Integer.parseInt(sc.nextLine());
                            if(numberChoiceStr >= 0 && numberChoiceStr <= 30 && pointsToSpend-numberChoiceStr > 0){
                                this.getAbilityScores().increaseStrength(numberChoiceStr);
                                pointsToSpend -= numberChoiceStr;
                            }
                            else{
                                p.displayString("Entrer un nombre valide");
                            }
                        break;
                        case 2:
                            p.displayString("Combien de points en Dextérité ? "+ pointsToSpend + " points restants.");
                            int numberChoiceDex = Integer.parseInt(sc.nextLine());
                            if(numberChoiceDex != 0 && numberChoiceDex <= 30 && pointsToSpend-numberChoiceDex > 0){
                                this.getAbilityScores().increaseDex(numberChoiceDex);
                                pointsToSpend -= numberChoiceDex;
                            }
                            else{
                                p.displayString("Entrer un nombre valide");
                            }
                        break;
                        case 3:
                            p.displayString("Combien de points en Intelligence ? "+ pointsToSpend + " points restants.");
                            int numberChoiceIntel = Integer.parseInt(sc.nextLine());
                            if(numberChoiceIntel != 0 && numberChoiceIntel <= 30 && pointsToSpend-numberChoiceIntel > 0){
                                this.getAbilityScores().increaseIntel(numberChoiceIntel);
                                pointsToSpend -= numberChoiceIntel;
                            }
                            else{
                                p.displayString("Entrer un nombre valide");
                            }
                        break;
                    }
                }         
                catch(NumberFormatException nfe)
                {
                    System.out.println("Entrer un nombre");
                }
            } 
            this.getExperience().setLevelUp(false);
        }
    }
    
    // getters
    public int getTotalArmor() {
        int totalArmor = 0;
        totalArmor += this.getArmorClass() + this.getArmorBuff();
        if (this.getHelmet() != null)
            totalArmor += this.getHelmet().getArmorClass();
        if (this.getPlackart() != null)
            totalArmor += this.getPlackart().getArmorClass();
        if (this.getGauntlet() != null)
            totalArmor += this.getGauntlet().getArmorClass();
        if (this.getTrousers() != null)
            totalArmor += this.getTrousers().getArmorClass();
        if (this.getBoots() != null)
            totalArmor += this.getBoots().getArmorClass();
        
        return totalArmor;
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

    public int getPosition() {
        return position;
    }
    
    
    public boolean isImmune(){
        boolean immune = false;
        if (!charStates.isEmpty()) {
            for(int i =0; i<charStates.size(); i++){
                if(charStates.get(i).isImmune()){
                    immune = true;
                }
            }
        }
        return immune;
    }
    
    public boolean isStunned(){
        boolean stunned = false;
        
        if (!charStates.isEmpty()) {
            for(int i =0; i<charStates.size(); i++){

                if(charStates.get(i).isStunned()){
                    stunned = true;
                }
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
    
    // Setters

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public void setMaxMP(int maxMP) {
        this.maxMP = maxMP;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }
    
    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public void setArmorBuff(int armorBuff) {
        this.armorBuff = armorBuff;
    }
    
    public void upMaxWeight(int val) {
        this.maxWeight += val;
    }
                
    public boolean isDead() {
        return (this.hp <= 0);
    }
}
