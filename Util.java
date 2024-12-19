/* Snake Game
 * Author: Colin Blum
 * Date: 11/1/2024
 */

import java.util.Random;

public class Util {
    public static void printCoordinate(int x, int y) {
        System.out.print(x);
        System.out.print(", ");
        System.out.println(y);
    }
    public static void printArray(int[] array, boolean newline) {
        System.out.print(array[0]);
        System.out.print(", ");
        if (newline) {
        System.out.println(array[1]);
        }
        else {
            System.out.print(array[1]);
        }
    }

    public static void print(int[] array) {
        System.out.print(array[0]);
        System.out.print(", ");
        System.out.print(array[1]);
    }

    public static void getGridValue(int[] target) {
        Util.printArray(target, false);
        System.out.print(": ");
        System.out.println(Grid.grid[target[0]][target[1]]);
    }

    public static int getRandom(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }
}
