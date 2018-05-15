
package zombies;

import skills.Skill;

public class Tank extends Zombie {
    static public int hiHit;

    public Tank() {
        super(2, 1, 2);
    }

    @Override
    public int calcHit(Skill skill) {
        return super.calcHit(skill) + getSpeed() * 2;
    }
}