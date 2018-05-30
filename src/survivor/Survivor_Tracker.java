
package survivor;

import weapons.Katana;

public class Survivor_Tracker extends Survivor {
    
    public Survivor_Tracker(Survivor survivor) {
        super(survivor.getName(), survivor.getWarcry());
        setWeapon(Katana.instantiate());
    }
}