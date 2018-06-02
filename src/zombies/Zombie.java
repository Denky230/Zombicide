
package zombies;

import survivor.Survivor;

public abstract class Zombie {
    private final int health;
    private final int damage;
    private final int speed;
    private final Horde horde;

    public Zombie(int health, int damage, int speed) {
        this.health = health;
        this.damage = damage;
        this.speed = speed;
        
        this.horde = new Horde();
        horde.walk();
   }

    public int getHealth() {
        return this.health;
    }
    public int getDamage() {
        return this.damage;
    }
    public int getSpeed() {
        return this.speed;
    }
    public Horde getHorde() {
        return this.horde;
    }

    public void hit(Survivor survivor) {
        survivor.takeDamage(getDamage(), getClass().getSimpleName());
    }

    public int calcHit(String skill) {
        int random = (int)(Math.random() * 10) + 1;
        int survivorSkillBonus = 0;
        int base = 10;

        switch (skill) {
            case "FAST":
                survivorSkillBonus = 5;
                break;
            case "TRACKER":
                survivorSkillBonus = 3;
                break;
            case "STRONG":
                survivorSkillBonus = 7;
                break;
            case "SLIPPERY":
                survivorSkillBonus = 9;
                break;
            case "BOTH_HANDED":
                survivorSkillBonus = 8;
                break;
            default:
        }

        return base * survivorSkillBonus + random;
    }

    public abstract int getHiHit();
}