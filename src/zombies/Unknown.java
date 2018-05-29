
package zombies;

import survivor.Survivor;

public class Unknown extends Zombie {
    private static int hiHit = 0;

    public Unknown() {
        super(2, 3, 1);
    }

    @Override
    public void hit(Survivor survivor) {
        super.hit(survivor);

        while (swipe()) {
            super.hit(survivor);
            System.out.println("This Uknown is on a rampage!");
        }
    }
    public boolean swipe() {
        return ((int)(Math.random() * 10) + 1) > 7;
    }

    @Override
    public int calcHit(String skill) {
        int currHiHit = hiHit;
        setHiHit(super.calcHit(skill) * getDamage());

        return hiHit == currHiHit ? 0 : 1;
    }

    @Override
    public int getHiHit() {
        return Unknown.hiHit;
    }
    public void setHiHit(int hit) {
        if (hit > Unknown.hiHit)
            Unknown.hiHit = hit;
    }
}