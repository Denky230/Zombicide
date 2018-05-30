
package survivor;

import weapons.Weapon;

public class Survivor_Fast extends Survivor {
    
    public Survivor_Fast(Survivor survivor) {
        super(survivor.getName(), survivor.getWarcry());
    }
    
    @Override
    public void setWeapon(Weapon weapon) {
        if (weapon != null) weapon.setDamage(2);
        super.setWeapon(weapon);
    }
}