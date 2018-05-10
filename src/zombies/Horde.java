
package zombies;

public class Horde {
    private int maxRespawn; // Attack cooldown
    private int respawn;

    public Horde(int respawn) {
        this.maxRespawn = this.respawn = respawn;
    }

    public int getRespawn() {
        return this.maxRespawn;
    }
    public int getCurrRespawn() {
        return this.respawn;
    }

    public void walk() {
        if (respawn > 0) respawn--;
    }

    public void resetRespawn() {
        this.respawn = this.maxRespawn;
    }
}
