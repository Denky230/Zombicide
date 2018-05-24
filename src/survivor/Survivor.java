
package survivor;

import skills.*;
import weapons.*;

public class Survivor {
    private int health;
    private int level;
    private String name;
    private String warcry;
    private Skills_enum skill;
    private Weapon weapon;

    public Survivor(String name) {
        this(name, 3, 5, "AAAAAH!", Skills_enum.FAST, new Pan());
    }
    public Survivor(String name, int health, int level, String warcry, Skills_enum skill, Weapon weapon) {
        this.name = name;
        this.health = health;
        this.level = level;
        this.warcry = warcry;
        this.skill = skill;
        this.weapon = weapon;
    }

    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health >= 0 ? health : 0;
    }

    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level >= 0 ? level : 0;
    }

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

    public Skills_enum getSkill() {
        return skill;
    }
    public void setSkill(Skills_enum skill) {
        this.skill = skill;
    }

    public Weapon getWeapon() {
        return weapon;
    }
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
        if (weapon != null)
            System.out.println(warcry);
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

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
}