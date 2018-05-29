
package zombies;

public class Walker extends Zombie {
    private static int hiHit = 0;

    public Walker() {
        super(1, 2, 2);
    }

    @Override
    public int calcHit(String skill) {
        int currHiHit = hiHit;
        setHiHit(super.calcHit(skill) + 5);

        return hiHit == currHiHit ? 0 : 1;
    }

    @Override
    public int getHiHit() {
        return Walker.hiHit;
    }
    public void setHiHit(int hit) {
    	if (hit > Walker.hiHit)
            Walker.hiHit = hit;
    }
}