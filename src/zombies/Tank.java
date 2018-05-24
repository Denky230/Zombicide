
package zombies;

public class Tank extends Zombie {
    static private int hiHit = 0;

    public Tank() {
        super(2, 1, 2);
    }

    @Override
    public int calcHit(String skill) {
        int currHiHit = this.hiHit;
        setHiHit(super.calcHit(skill) + getSpeed() * 2);

        return hiHit == currHiHit ? 0 : 1;
    }

    @Override
    public int getHiHit() {
        return this.hiHit;
    }
    public void setHiHit(int hit) {
    	if (hit > this.hiHit)
            this.hiHit = hit;
    }
}