
package weapons;

public class WeaponFactory {
    
    public static Weapon buildWeapon(WeaponClasses weaponName) {
        switch (weaponName) {
            case PAN:
                return Pan.instantiate();
            case AXE:
                return Axe.instantiate();
            case KATANA:
                return Katana.instantiate();
            case GUN:
                return Gun.instantiate();
            case SHOTGUN:
                return Shotgun.instantiate();
            default:
                return null;
        }
    }
}