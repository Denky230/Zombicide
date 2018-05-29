
package survivor;

import weapons.Weapon;

public class Survivor_Fast extends Survivor {

    public Survivor_Fast(Survivor survivor) {
        super(survivor.getName(), survivor.getHealth(), survivor.getLevel(), survivor.getWarcry(), survivor.getSkill(), survivor.getWeapon());
    }
    
    @Override
    public void setWeapon(Weapon weapon) {
        if (weapon != null) weapon.setDamage(2);
        super.setWeapon(weapon);
    }
}
