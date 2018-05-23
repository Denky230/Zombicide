
package zombies;

public class Unknown extends Zombie {
    static private int hiHit;

    public Unknown() {
        super(2, 3, 1);
    }

    @Override
    public int calcHit(String skill) {
        int currHiHit = hiHit;
    	setHiHit(super.calcHit(skill) * getDamage());        

        return hiHit == currHiHit ? 1 : 0;
    }

    @Override
    public int getHiHit() {
        return this.hiHit;
    }
    public void setHiHit(int hit) {
        if (hit > this.hiHit)
            this.hiHit = hit;
    }

    public boolean swipe() {
        /*
        TO DO: random btwn 1 - 10; if result > 7, hit again
        maybe include this in super.hit() (override hit)
        */

        return false;
    }
}
