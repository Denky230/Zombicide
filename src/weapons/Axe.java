
package weapons;

public class Axe extends Weapon {    
    public static int stock = 2;
    
    private Axe() {
        super(2, 0);
    }    
    
    public static Axe instantiate() {
        if (stock > 0) {
            stock--;
            return new Axe();
        } else return null;
    }
}