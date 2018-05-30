
package survivor;

import weapons.Weapon;

public class Survivor {
    //private int level;
    private int health;    
    private String name;
    private String warcry;
    private Weapon weapon;

    public Survivor(String name) {
        this(name, "AAAAAH!");
    }    
    public Survivor(String name, String warcry) {
        this.name = name;
        this.warcry = warcry;
        
        this.health = 3;
    }

    @Override
    public String toString() {
        String skill = getClass().getSimpleName().substring(9);  // Get just the subclass skill
        
        return getName() + "\n\t"
                + "Health: " + getHealth() + "\n\t"
                + "Skill: " + skill + "\n\t"
                + "Weapon: " + getWeapon().getClass().getSimpleName() + "\n\t\t"
                + "Damage: " + getWeapon().getDamage();
    }

    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health >= 0 ? health : 0;
    }

    /*
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level >= 0 ? level : 0;
    }
    */

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getWarcry() {
        return warcry;
    }
    public void setWarcry(String warcry) {
        this.warcry = warcry;
    }

    public Weapon getWeapon() {
        return weapon;
    }
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
        if (weapon != null)
            System.out.println(getName() + " has recieved a " + weapon.getClass().getSimpleName() + "! " + warcry);
    }

    public boolean hasWeapon() {
        return getWeapon() != null;
    }
    public void destroyWeapon() {
        setWeapon(null);
    }

    public boolean hit() {
        return (int)(Math.random() + 0.5) == 1;
    }

    public void takeDamage(int damage, String zombieClass) {
        setHealth(getHealth() - damage);

        // Print Surv remaining HP (if any)
        System.out.println(
                getHealth() != 0 ?
                    getName() + " was hit by a " + zombieClass + "! - HP remaining: " + getHealth() :
                    getName() + " was killed by a " + zombieClass + "! :("
        );
    }

    // Called when entering new floor
    public void reset() {}
}