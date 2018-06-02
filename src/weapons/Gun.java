
package weapons;

public class Gun extends Weapon {    
    public static int stock = 1;
    
    private Gun() {
        super(2, 2);
    }
    
    public static Gun instantiate() {
        if (stock > 0) {
            stock--;
            return new Gun();
        } else return null;
    }
}