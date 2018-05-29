
package survivor;

import skills.Skills;
import weapons.Weapon;
import weapons.Katana;

public class Survivor {
    private int health;
    private int level;
    private String name;
    private String warcry;
    private Skills skill;
    private Weapon weapon;

    public Survivor(String name) {
        this(name, 3, 0, "AAAAAH!", null, null);
    }
    public Survivor(String name, int health, int level, String warcry) {
        this(name, health, level, warcry, null, null);
    }
    public Survivor(String name, int health, int level, String warcry, Skills skill, Weapon weapon) {
        this.name = name;
        this.health = health;
        this.level = level;
        this.warcry = warcry;
        this.skill = skill;
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        String skillName = getSkill().name().toLowerCase();
        skillName = skillName.toUpperCase().charAt(0) + skillName.substring(1, skillName.length());

        return getName() + "\n\t"
                + "Health: " + getHealth() + "\n\t"
                + "Skill: " + skillName + "\n\t"
                + "Weapon: " + getWeapon().getClass().getSimpleName() + "\n\t\t"
                + "Damage: " + getWeapon().getDamage();
    }

    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health >= 0 ? health : 0;
    }

    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level >= 0 ? level : 0;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getWarcry() {
        return warcry;
    }
    public void setWarcry(String warcry) {
        this.warcry = warcry;
    }

    public Skills getSkill() {
        return skill;
    }
    public void setSkill(Skills skill) {
        this.skill = skill;
    }

    public Weapon getWeapon() {
        return weapon;
    }
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
        if (weapon != null)
            System.out.println(getName() + " has recieved a " + weapon.getClass().getSimpleName() + "! " + warcry);
    }

    public boolean hasWeapon() {
        return getWeapon() != null;
    }
    public void destroyWeapon() {
        setWeapon(null);
    }

    public boolean hit() {
        return (int)(Math.random() + 0.5) == 1;
    }

    public void takeDamage(int damage, String zombieClass) {
        setHealth(getHealth() - damage);

        // Print Surv remaining HP (if any)
        System.out.println(
                getHealth() != 0 ?
                    getName() + " was hit by a " + zombieClass + "! - HP remaining: " + getHealth() :
                    getName() + " was killed by a " + zombieClass + "! :("
        );
    }

    // Apply effects depending on skill
    public void applySkills() {
        switch (getSkill()) {
            case TRACKER:
                setWeapon(Katana.instantiate());
                break;
            case STRONG:
                setHealth(getHealth() + 1);
                break;
            default:
        }
    }

    // Called when entering new floor
    public void reset() {}
}