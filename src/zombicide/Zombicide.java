
package zombicide;

import survivor.*;
import skills.*;
import weapons.*;
import zombies.*;

public class Zombicide {
    public static void main(String[] args) {
        /* FLOOR 01 */
        // Set survivors
        Survivor[] myTeam = new Survivor[] {
            new Survivor("Rick", "COWABUNGA!", Skills_enum.FAST, new Katana()),
            new Survivor("Alfredo", "BAZINGA!", Skills_enum.TRACKER, new Gun()),
            new Survivor("John", "COME AT ME!", Skills_enum.STRONG, new Shotgun()),
            new Survivor("Manueh"),
            new Survivor("Carla")
        };

        // Set zombie wave
        Zombie[] zombieWave_01 = new Zombie[5];
        for (int i = 0; i < zombieWave_01.length; i++){
            zombieWave_01[i] = new Walker();
        }
    }
}
