/* Snake Game
 * Author: Colin Blum
 * Date: 11/1/2024
 */

import java.awt.Color;
import java.awt.Graphics;

public class Apple extends Object{
    public static int[] appleCoordinates = {Util.getRandom(Grid.xFrame/Grid.gridUnitSize), Util.getRandom(Grid.yFrame/Grid.gridUnitSize)};

    @Override
    public void Spawn() {
        while(snakeCheck()) {
            appleCoordinates[0] = Util.getRandom(Grid.xFrame/Grid.gridUnitSize);
            appleCoordinates[1] = Util.getRandom(Grid.yFrame/Grid.gridUnitSize);
        }
        Grid.isApple = true;
        Grid.grid[appleCoordinates[0]][appleCoordinates[1]] = this;
    }

    @Override
    public Graphics Draw(Graphics g, int i, int j) {
        return Grid.drawSquare(g, Color.RED, i, j);
    }

    private boolean snakeCheck() {
        if ((Grid.grid[appleCoordinates[0]][appleCoordinates[1]] instanceof Snake)) {
            return true;
        }
        return false;
    }
}
