
package weapons;

import zombicide.Zombicide;

public class Pan extends Weapon {
    public static int stock = Zombicide.myTeam.length;

    private Pan() {
        super(1, 0);
    }
    
    public static Pan instantiate() {
        if (stock > 0) {
            stock--;
            return new Pan();
        } else return null;
    }
}