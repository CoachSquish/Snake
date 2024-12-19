/* Snake Game
 * Author: Colin Blum
 * Date: 11/1/2024
 */

import java.util.ArrayList;
import java.awt.event.KeyEvent;

public class Snake {
    public static int[] head = {Grid.xFrame/Grid.gridUnitSize/2, Grid.yFrame/Grid.gridUnitSize/2};
    public static ArrayList<int[]> snake = new ArrayList<>();
    public static boolean gameOver = false;

    private static int[] direction = { 0 , -1 };

    public static void spawnSnake() {
        if(snake.size() != 0) {
            for(int i = 0; i < snake.size() - 1; i++) {
                snake.remove(0);
            }
        }

        snake.add(head);
        int[] tailOne = { head[0], head[1] + 1 }; 
        snake.add(tailOne);
        int[] tailTwo = { tailOne[0], tailOne[1] + 1 }; 
        snake.add(tailTwo);

        displaySnakeOnGrid();
    }

    public static void moveSnake() {
        int[] newHead = { head[0] + direction[0], head[1] + direction[1] };
        if((newHead[0] > Grid.xFrame/Grid.gridUnitSize - 1) || (newHead[1] > Grid.yFrame/Grid.gridUnitSize - 1) || (newHead[0] < 0) || (newHead[1] < 0)) { // Is snake out of bounds?
            gameOver = true;
        }
        boolean grow = appleCheck(newHead);
        snakeCheck(newHead);
        head = newHead;
        snake.add(0, head);
        if(!grow) {
            Grid.grid[snake.get(snake.size()-1)[0]][snake.get(snake.size() - 1)[1]] = ""; // This Long line of saddness gets the coordinates of the end of the snake on the grid
            snake.remove(snake.size() - 1);
        }
        displaySnakeOnGrid();
    }

    public static void getDirection(KeyEvent key) {
        if(!gameOver) {    
            int[] retVal = { 0, 0 };
            int userInput = key.getKeyCode();
            switch(userInput) {
                case KeyEvent.VK_UP:
                    if(direction[1] != 1) {
                        retVal[1] = -1;
                        break;
                    }
                case KeyEvent.VK_DOWN:
                    if(direction[1] != -1) {
                        retVal[1] = 1;
                        break;
                    }
                case KeyEvent.VK_LEFT:
                    if(direction[0] != 1) {
                        retVal[0] = -1;
                        break;
                    }
                case KeyEvent.VK_RIGHT:
                    if(direction[0] != -1) {
                        retVal[0] = 1;
                        break;
                    }
                default:
                    retVal = direction;
            }
            direction = retVal;
        }
    }

    private static boolean appleCheck(int[] newHead) {
        if(Grid.grid[newHead[0]][newHead[1]] == "apple") {
            Apple.isApple = false;
            return true;
        }
        return false;
    }

    private static void snakeCheck(int[] newHead) {
        if(Grid.grid[newHead[0]][newHead[1]] == "snake") {
            gameOver = true;
        }
    }

    private static void displaySnakeOnGrid() {
        for (int i = 0; i < snake.size(); i++) {
            Grid.grid[snake.get(i)[0]][snake.get(i)[1]] = "snake";
        }
    }
}
