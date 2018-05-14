
package zombies;

import skills.Skill;

public class Unknown extends Zombie {
    static public int hiHit;

    public Unknown() {
        super(2, 3, 1);
    }

    public boolean swipe() {
    	// TO DO: random btwn 1 - 10; if result > 7, hit again
        return false;
    }

    public int calcHit(Skill skill) {
    	return super.calcHit(skill) * getDamage();
    }
}
