
package zombies;

import skills.Skill;

public class Walker extends Zombie {
    static public int hiHit;
    
    public Walker() {
        super(1, 2, 2);
    }
    
    @Override
    public int calcHit(Skill skill) {
        return super.calcHit(skill) + 5;
    }
}
