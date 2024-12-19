/* Snake Game
 * Author: Colin Blum
 * Date: 11/1/2024
 */

import java.awt.*;

public class Grid {
    public static int xFrame = 500;
    public static int yFrame = 500;
    public static int gridUnitSize = 20;
    public static String[][] grid = new String[xFrame/gridUnitSize][yFrame/gridUnitSize];

    public static void initializeGrid() {
        for (int i = 0; i < grid.length; i++) { 
            for (int j = 0; j < grid[i].length; j++) {  
                grid[i][j] = "";   
            }
        }
    }

    public static Graphics drawSquare(Graphics g, Color color, int x, int y) {
        x = x * gridUnitSize;
        y = y * gridUnitSize;
        g.setColor(color);
        g.fillRect(x, y, gridUnitSize, gridUnitSize);
        return g;
    }

    public static Graphics erase(Graphics g, int x, int y) {
        return drawSquare(g, Color.WHITE, x, y);
    }
}
