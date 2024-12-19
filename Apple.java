/* Snake Game
 * Author: Colin Blum
 * Date: 11/1/2024
 */

public class Apple {
    public static int[] appleCoordinates = {Util.getRandom(Grid.xFrame/Grid.gridUnitSize), Util.getRandom(Grid.yFrame/Grid.gridUnitSize)};
    public static boolean isApple = false;

    public static void spawnApple() {
        while(snakeCheck()) {
            appleCoordinates[0] = Util.getRandom(Grid.xFrame/Grid.gridUnitSize);
            appleCoordinates[1] = Util.getRandom(Grid.yFrame/Grid.gridUnitSize);
        }
        isApple = true;
        Grid.grid[appleCoordinates[0]][appleCoordinates[1]] = "apple";
    }

    private static boolean snakeCheck() {
        if ((Grid.grid[appleCoordinates[0]][appleCoordinates[1]] == "snake")) {
            return true;
        }
        return false;
    }
}
