
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
        int NUM_FLOORS = 3;
        int currFloor = 1;
        
        int HORDE_SIZE = 8;
        List<Zombie> zombieHorde = new ArrayList<>();
        
        // Set survivors
        myTeam = new Survivor[] {
            new Survivor("Rick", "COWABUNGA!", Skills_enum.FAST, new Katana()),
            new Survivor("Alfredo", "BAZINGA!", Skills_enum.TRACKER, new Gun()),
            new Survivor("John", "COME AT ME!", Skills_enum.STRONG, new Shotgun()),
            new Survivor("Manueh"),
            new Survivor("Carla")
        };      
                
        // GAME LOOP
        while (currFloor <= NUM_FLOORS) {
            // Set floor specifics
            switch (currFloor) {
                case 1: // Floor 1 - Just Walkers
                    for (int i = 0; i < HORDE_SIZE; i++){
                       zombieHorde.add(new Walker());
                    }
                    break;
                case 2: // Floor 2 - Walkers + Tanks
                    break;
                case 3: // FLoor 3 - Walkers + Tanks + 1 Unknown
                    break;
                default:
            }
            
            fight(zombieHorde);
            System.out.println();
            
            currFloor++;
        }
    }

    public static List survivorsGo(List<Zombie> zombiesAlive) {
        int NUM_SURVIVOR_ATTACKS = 3;
        Zombie target; // Current attack target
        
        System.out.println("-- Survivors attacks --");
        for (Survivor s : myTeam) {
            for (int i = 0; i < NUM_SURVIVOR_ATTACKS; i++) {
                // Get a random zombie's index from the "still alive" zombie pool
                target =  zombiesAlive.get((int)(Math.random() * zombiesAlive.size()));

                // Make s hit target
                if (s.hit()) {
                    // Check whether damage is enough to kill target
                    if (s.getWeapon().getDamage() >= target.getHealth()) {
                        zombiesAlive.remove(target);
                        System.out.println(target.getClass().getName().substring(8) + " slain!");
                    } else {
                        System.out.println("The damage was too low :(");
                    }
                } else {
                    System.out.println("Fail");
                }
                
                // Check if there's any alive zombie left
                if (zombiesAlive.isEmpty()) {
                    System.out.println();
                    return zombiesAlive;
                }
                    
            }
            System.out.println();
        }

        return zombiesAlive;
    }

    public static void zombiesGo(List<Zombie> zombieAlive) {
        int NUM_ZOMBIE_ATTACKS = 1;
        int target; // Current attack target

        System.out.println("-- ZombieHorde attacks --");
        for (Zombie z : zombieAlive) {
            for (int i = 0; i < NUM_ZOMBIE_ATTACKS; i++) {
                // Get a random survivor's index
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

    public static void fight(List<Zombie> zombieHorde) {
        zombieHorde = survivorsGo(zombieHorde);
        System.out.println(zombieHorde.size() + " zombies left");
    }
}
