
package zombies;

public abstract class Zombie {
    private int damage;
    private int speed;

    public Zombie(int damage, int speed) {
        this.damage = damage;
        this.speed = speed;
   }

    public int getDamage() {
        return damage;
    }
    public int getSpeed() {
        return speed;
    }

    public void calcHit() {
        int random = (int)(Math.random() * 10) + 1;
    }
}