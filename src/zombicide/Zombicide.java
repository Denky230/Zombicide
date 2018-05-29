
package zombicide;

import java.util.List;
import java.util.ArrayList;

import survivor.*;
import skills.*;
import weapons.*;
import zombies.*;

public class Zombicide {

    public static Survivor[] myTeam;
    static List<Zombie> zombieHorde = new ArrayList<>();

    public static void main(String[] args) {
        // Floor vars
        final int NUM_FLOORS = 3;
        int currFloor = 1;
        // Zombie vars
        final int HORDE_SIZE = 8;

        // Set survivors
        myTeam = new Survivor[] {
            new Survivor("Rick", 3, 0, "COWABUNGA!"),
            new Survivor("Alfredo", 3, 0, "BAZINGA!"),
            new Survivor("John", 3, 0, "COME AT ME!"),
            new Survivor("Manueh"),
            new Survivor("Carla")
        };

        String team = "";
        for (Survivor s : myTeam) {
            team += s.getName() + ", ";
        }
        team = team.substring(0, team.length() - 2);

        // LORE
        System.out.println(
                "We find ourselves in a building plagued with "
                + "zombies and,\nsadly, our only option is to fight our way "
                + "up to the roof...\n\n"
                + "This is our team: " + team + ".\nNow let's roll whatever "
                + "few equipment we have.\n"
        );

        System.out.println("-- Equipment roll --\n");
        // Assign skill randomly to each Survivor
        rollSkills();

        // Apply each Survivor's skill effects
        for (int i = 0; i < myTeam.length; i++) {
            myTeam[i].applySkills();

            // Convert Survivor to subclass when needed
            switch (myTeam[i].getSkill()) {
                case SLIPPERY:
                    myTeam[i] = new Survivor_Slippery(myTeam[i]);
                    break;
                case FAST:
                    myTeam[i] = new Survivor_Fast(myTeam[i]);
                    break;
                default:
            }
        }

        // Assign weapons randomly to Survivors who still don't have one
        rollWeapons();
        System.out.println();

        // Print team info
        soutTeam();

        // GAME LOOP
        while (currFloor <= NUM_FLOORS) {
            // Set floor specifics
            switch (currFloor) {
                case 1: // Floor 1 - Just Walkers
                    for (int i = 0; i < HORDE_SIZE; i++){
                       zombieHorde.add(new Walker());
                    }
                    break;
                case 2: // TO DO: Floor 2 - Walkers + Tanks
                    fillZombieHorde(HORDE_SIZE);
                    break;
                case 3: // TO DO: FLoor 3 - Walkers + Tanks + 1 Unknown
                    fillZombieHorde(HORDE_SIZE);

                    // Make sure Unknown won't sub in for a side-Tank Walker
                    int randIndex = -1;
                    do {
                        randIndex = (int)(Math.random() * HORDE_SIZE);
                        // Check if randIndex == Walker next to Tank
                        if (zombieHorde.get(randIndex) instanceof Walker) {
                            if (randIndex == 0) {
                                // Check if right == Tank
                                if (zombieHorde.get(randIndex + 1) instanceof Tank)
                                    randIndex = -1;
                            } else if (randIndex == zombieHorde.size() - 1) {
                                // Check if left == Tank
                                if (zombieHorde.get(randIndex - 1) instanceof Tank)
                                    randIndex = -1;
                            } else {
                                // Check if right / left == Tank
                                if (zombieHorde.get(randIndex + 1) instanceof Tank ||
                                    zombieHorde.get(randIndex - 1) instanceof Tank)
                                    randIndex = -1;
                            }
                        }
                    } while (randIndex == -1);

                    // Sub random zombie for an Unknown
                    zombieHorde.set(randIndex , new Unknown());
                    break;
                default:
            }

            System.out.println("/// FLOOR " + currFloor + " /// \n");
            for (Zombie z : zombieHorde) {
                System.out.print(z.getClass().getSimpleName().charAt(0) + " ");
            }
            System.out.println("\n");

            // Fight - If Survivors lose exit game, else move on
            if (!fight()) {
                // GAME OVER
                System.out.println("Game Ovah");
                break;
            }

            // Reset survivors & horde and go next floor
            for (Survivor s : myTeam) {
                s.reset();
            }
            zombieHorde.clear();
            currFloor++;
        }

        // GAME END
        System.out.println("You won! YUHUUU!");
    }

    /**
     * Fill zombieHorde with Walkers (W) / Tanks (T) randomly.
     * T must have W on each side.
     */
    public static void fillZombieHorde(int hordeSize) {
        // Add Walker at first position
        zombieHorde.add(new Walker());

        // Fill ArrayList from index 1 to last - 1
        for (int i = 1; i < hordeSize - 1; i++) {            
            // Check if Zombie to the left is a Walker
            if (zombieHorde.get(i - 1) instanceof Walker) {

                // 50/50 between Walker or Tank
                if ((int)(Math.random() + 0.5) == 0)
                    zombieHorde.add(new Walker());
                else zombieHorde.add(new Tank());

            } else zombieHorde.add(new Walker());
        }
        // Add Walker at last position
        zombieHorde.add(new Walker());
    }

    public static boolean fight() {
        int targetsAlive = zombieHorde.size(); // Members alive after each attack
        boolean turn = true; // Manages who attacks

        while (targetsAlive > 0) {
            if (turn) {
                // Survivors attack
                survivorsGo();
                // Store zombies left
                targetsAlive = zombieHorde.size();

                System.out.println(targetsAlive + " zombies left \n");
            } else {
                // Zombies attack
                zombiesGo();
                // Store survivors left
                targetsAlive = 0;
                for (Survivor s : myTeam) {
                    if (s.getHealth() > 0) targetsAlive++;
                }

                if (targetsAlive == 0) return false;
                else System.out.println(targetsAlive + " survivors left \n"); 
            }

            turn = !turn;
        }

        return true;
    }

    public static void survivorsGo() {
        int NUM_SURVIVOR_ATTACKS = 3;
        Zombie target; // Current attack target

        System.out.println("-- Survivors --");
        for (Survivor s : myTeam) {
            // If Survivor is both-handed && has a Gun equipped attacks x2
            if (s.getSkill() == Skills.BOTH_HANDED && s.getWeapon() instanceof Gun)
                NUM_SURVIVOR_ATTACKS *= 2;

            for (int i = 0; i < NUM_SURVIVOR_ATTACKS; i++) {
                // Get random zombie's index from "still alive" zombie pool
                target =  zombieHorde.get((int)(Math.random() * zombieHorde.size()));

                // Make Survivor attack Zombie (target)
                if (s.hit()) {
                    // Check if damage is enough to kill target
                    if (s.getWeapon().getDamage() >= target.getHealth()) {
                        zombieHorde.remove(target);
                        System.out.println(target.getClass().getName().substring(8) + " slain!");
                    } else {
                        System.out.println("Damage was too low :(");
                    }
                } else {
                    System.out.println("Miss");
                }

                // Check if there's any alive zombie left
                if (zombieHorde.isEmpty()) {
                    System.out.println();
                    return;
                }
            }
            System.out.println();
        }
    }

    public static void zombiesGo() {
        int target; // Current attack target

        System.out.println("-- Zombies --");
        for (Zombie z : zombieHorde) {
            // Get a random survivor's index
            target =  (int)(Math.random() * myTeam.length);

            // Make Zombie attack Survivor (target)
            z.hit(myTeam[target]);

            // Zombie calcHit()
            if (z.calcHit(myTeam[target].getSkill().name()) == 1)
                System.out.println(z.getClass().getSimpleName() + "s have a new top hit - " + z.getHiHit() + "!");

            System.out.println();
        }
    }

    public static void rollSkills() {
        for (Survivor s : myTeam) {
            s.setSkill(Skills.values()[(int)(Math.random() * Skills.values().length)]);
        }
    }

    public static void rollWeapons() {
        WeaponFactory factory = new WeaponFactory();

        for (Survivor s : myTeam) {
            // Make sure a weapon out of stock is not being assigned
            while (s.getWeapon() == null) {                
                s.setWeapon(factory.buildWeapon(WeaponClasses.values()[(int)(Math.random() * WeaponClasses.values().length)]));                
            }
        }
    }

    public static void soutTeam() {
        System.out.println("-- Team Info --\n");
        for (Survivor s : myTeam) {
            System.out.println(s.toString()+ "\n");
        }
    }
}