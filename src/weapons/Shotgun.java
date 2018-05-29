
package weapons;

public class Shotgun extends Weapon {    
    public static int stock = 1;

    private Shotgun() {
        super(4, 1);
    }
    
    public static Shotgun instantiate() {
        if (stock > 0) {
            stock--;
            return new Shotgun();
        } else return null;
    }
}