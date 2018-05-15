
package zombicide;

import survivor.*;
import skills.*;
import weapons.*;
import zombies.*;
import java.util.List;
import java.util.ArrayList;

public class Zombicide {

    static Survivor[] myTeam;

    public static void main(String[] args) {
        // Set survivors
        myTeam = new Survivor[] {
            new Survivor("Rick", "COWABUNGA!", Skills_enum.FAST, new Katana()),
            new Survivor("Alfredo", "BAZINGA!", Skills_enum.TRACKER, new Gun()),
            new Survivor("John", "COME AT ME!", Skills_enum.STRONG, new Shotgun()),
            new Survivor("Manueh"),
            new Survivor("Carla")
        };

        // Set zombie wave
        Zombie[] zombieHorde = new Zombie[8];
        for (int i = 0; i < zombieHorde.length; i++){
            zombieHorde[i] = new Walker();
        }

        survivorsGo(zombieHorde);
        zombiesGo(zombieHorde);

        // TO DO: wrap up fight (fight(){while team || zombies alive})
    }

    public static void survivorsGo(Zombie[] zombieHorde) {
        int NUM_SURVIVOR_ATTACKS = 3;
        int target; // Current attack target

        // To store alive zombies' index
        List<Integer> zombiesAlive = new ArrayList<>();
        for (int i = 0; i < zombieHorde.length; i++) {
            zombiesAlive.add(i);
        }

        /* System.out.println("-- Zombie Horde --");
        for (int i = 0; i < zombieHorde.length; i++) {
            System.out.println(i + " " + zombieHorde[i].toString());
        }
        System.out.println(); */

        System.out.println("-- Survivors attacks --");
        for (Survivor s : myTeam) {
            if (s.getHealth() > 0){
                for (int i = 0; i < NUM_SURVIVOR_ATTACKS; i++) {
                    // Get a random zombie's index from the "still alive" zombie pool
                    target =  zombiesAlive.get((int)(Math.random() * zombiesAlive.size()));

                    //System.out.println(target + " " + zombieHorde[target].toString());                

                    // Make s hit target
                    if (s.hit()) {
                        // Check whether damage is enough to kill target
                        if (s.getWeapon().getDamage() >= zombieHorde[target].getHealth()) {
                            zombiesAlive.remove(zombiesAlive.indexOf(target));
                            System.out.println(zombieHorde[target].getClass().getName().substring(8) + " slain!");
                        } else {
                            System.out.println("The damage was too low :(");
                        }
                    } else {
                        System.out.println("Fail");
                    }

                    if (zombiesAlive.isEmpty())
                        return;
                }
                System.out.println();
            }
        }
    }

    public static void zombiesGo(Zombie[] zombieHorde) {
        int NUM_ZOMBIE_ATTACKS = 1;
        int target; // Current attack target

        System.out.println("-- ZombieHorde attacks --");
        for (Zombie z : zombieHorde) {
            for (int i = 0; i < NUM_ZOMBIE_ATTACKS; i++) {
                // Get a random zombie from the "still alive" zombie pool
                target =  (int)(Math.random() * myTeam.length);

                // Make z hit target
                if (z.hit()) {
                    // TO DO: make z do damage
                    myTeam[target].setHealth(myTeam[target].getHealth() - z.getDamage());
                    System.out.println(myTeam[target].getName() + " was hit! HP remaining: " + myTeam[target].getHealth());
                } else {
                    System.out.println("Fail");
                }

                // TO DO: Lose logic
            }
            System.out.println();
        }
    }
}
