
package zombies;

import skills.Skill;

public class Unknown extends Zombie {
    static public int hiHit;

    public Unknown() {
        super(2, 3, 1);
    }

    public int calcHit(Skill skill) {
    	return super.calcHit(skill) * getDamage();
    }
}
