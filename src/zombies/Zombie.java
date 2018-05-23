
package zombies;

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