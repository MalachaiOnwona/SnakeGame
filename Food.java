package snakegame;

/**
 * This class represents the food
 * that the snake eats in the game
 * window
 * 
 * @author Malachai Onwona
 * @version 05.16.2023
 */

public class Food {

    private int x;
    private int y;

    /**
     * This constructor creates
     * a Food object and generates
     * the spawn point for the food
     * 
     * @param snake
     *            The snake that will
     *            eat the food
     */

    public Food(Snake snake) {

        this.spawn(snake);

    }


    /**
     * This method generates a new
     * spawn point for the food once
     * it has been eaten by the snake.
     * 
     * @param snake
     *            The snake that is
     *            in the game window
     */

    public void spawn(Snake snake) {

        boolean isOnSnake = true;

        while (isOnSnake) {

            isOnSnake = false;

            x = (int)(Math.random() * GameWindow.width - 1);
            y = (int)(Math.random() * GameWindow.height - 1);

            for (int i = 0; i < snake.getBody().size(); i++) {
                if (snake.getBody().get(i).getX() == x && snake.getBody().get(i)
                    .getY() == y) {
                    isOnSnake = true;
                }
            }
        }
    }


    /**
     * This method returns the
     * x-coordinate of the food
     * 
     * @return the x-coordinate of the food
     */

    public int getX() {
        return x;
    }


    /**
     * This method returns the
     * y-coordinate of the food
     * 
     * @return the y-coordinate of the food
     */

    public int getY() {
        return y;
    }

}
