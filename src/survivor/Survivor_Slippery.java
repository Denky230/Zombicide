
package survivor;

public class Survivor_Slippery extends Survivor {
    boolean dodgedThisFloor = false;

    public Survivor_Slippery(Survivor survivor) {
        super(survivor.getName(), survivor.getHealth(), survivor.getLevel(), survivor.getWarcry(), survivor.getSkill(), survivor.getWeapon());
    }   
    
    @Override
    public void takeDamage(int damage, String zombieClass) {
        if (!dodgedThisFloor) {
            dodgedThisFloor = true;
            System.out.println(getName() + " somehow managed to dodge the hit!");
        } else {
            super.takeDamage(damage, zombieClass);
        }
    }
    
    @Override
    public void reset() {
        dodgedThisFloor = false;
    }
}