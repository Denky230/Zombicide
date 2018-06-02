
package weapons;

public class Katana extends Weapon {
    public static int stock = 1;

    private Katana() {
        super(2, 0);
    }

    public static Katana instantiate() {
        if (stock > 0) {
            stock--;
            return new Katana();
        } else return null;
    }
}