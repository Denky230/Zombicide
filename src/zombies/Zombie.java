
package zombies;

import skills.Skill;

public abstract class Zombie {
    private int health;
    private int damage;
    private int speed;

    public Zombie(int health, int damage, int speed) {
        this.health = health;
        this.damage = damage;
        this.speed = speed;
   }

    public int getHealth() {
        return health;
    }
    public int getDamage() {
        return damage;
    }
    public int getSpeed() {
        return speed;
    }

    public int calcHit(Skill skill) {
        int random = (int)(Math.random() * 10) + 1;
        int survivorSkillBonus = 0;
        int base = 10;

        String skillName = skill.getClass().getName().substring(7);
        switch (skillName) {
            case "Fast":
                survivorSkillBonus = 5;
                break;
            case "Tracker":
                survivorSkillBonus = 3;
                break;
            case "Strong":
                survivorSkillBonus = 7;
                break;
            case "Slippery":
                survivorSkillBonus = 9;
                break;
            case "Both_handed":
                survivorSkillBonus = 8;
                break;
            default:
        }
        
        return base * survivorSkillBonus + random + 5;
    }
}