
package weapons;

public abstract class Weapon {
    private int damage;
    private int distance;
    
    public Weapon(int damage, int distance) {
        this.damage = damage;
        this.distance = distance;
    }

    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDistance() {
        return distance;
    }
}