
package survivor;

public class Survivor_Strong extends Survivor {
    
    public Survivor_Strong(Survivor survivor) {
        super(survivor.getName(), survivor.getWarcry());
        setHealth(getHealth() + 1);
    }
}