
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
        Zombie[] zombieHorde = new Zombie[5];
        for (int i = 0; i < zombieHorde.length; i++){
            zombieHorde[i] = new Walker();
        }

        fight(zombieHorde);
    }

    public static void fight(Zombie[] zombieHorde) {
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

        System.out.println("-- Survs attacks --");
        for (Survivor s : myTeam) {            
            for (int i = 0; i < NUM_SURVIVOR_ATTACKS; i++) {
                // Get a random zombie from the "still alive" zombie pool
                target =  zombiesAlive.get((int)(Math.random() * zombiesAlive.size()));
                
                System.out.println(target + " " + zombieHorde[target].toString());                
                
                // TO DO: make s hit target
                 
                zombiesAlive.remove(zombiesAlive.indexOf(target));
                if (zombiesAlive.isEmpty())
                    return;
            }
            System.out.println();
        }
    }
}
