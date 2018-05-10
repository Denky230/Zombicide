
package survivor;

import skills.*;
import weapons.*;

public class Survivor {
    private int lives;
    private int level;
    private String name;
    private String warcry;
    private Skills_enum skill;
    private Weapon weapon;

    public Survivor(String name){
        this(name, "", Skills_enum.FAST, new Pan());
    }
    public Survivor(String name, String warcry, Skills_enum skill, Weapon weapon) {
        this.lives = lives;
        this.level = level;
        this.name = name;
        this.warcry = warcry;
        this.skill = skill;
        this.weapon = weapon;
    }

    public int getLives() {
        return lives;
    }
    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
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
}