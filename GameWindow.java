package snakegame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 * This class represents the window
 * that the game will be played in
 * 
 * @author Malachai Onwona
 * @version 05.16.2023
 */

public class GameWindow implements KeyListener {

    private Snake snake;
    private Food apple;
    private Graphics graphics;
    private JFrame window;

    /**
     * This variable represents the width
     * of the window
     */

    public static final int width = 25;

    /**
     * This variable represents the height
     * of the window
     */
    public static final int height = 25;

    /**
     * This variable represents the factor
     * that will be applied to different
     * aspects of the window
     */
    public static final int factor = 20;

    /**
     * This constructor creates a window and
     * instantiates the Snake, Food, and Graphics
     * objects that are utilized in the game. Functionality
     * for the window is also implemented.
     */

    public GameWindow() {

        snake = new Snake();
        apple = new Food(snake);
        graphics = new Graphics(this);

        window = new JFrame();
        window.setTitle("Snake Game");
        window.setSize(width * factor + 2, height * factor + 4);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(graphics);
        window.addKeyListener(this);

    }


    /**
     * This method starts the game by changing
     * the value of the string which represents
     * the state of the game.
     */

    public void start() {

        graphics.current = "RUNNING";

    }


    /**
     * This method provides updates for the game
     * when certain actions occur. When the game
     * is running and the snake eats the food, the
     * snake grows and new food spawns in the window.
     * When the snake collides with the wall of the window
     * or itself, the game ends. If none of those collisions occur
     * the snake continues to move.
     */

    public void update() {

        if (graphics.current == "RUNNING") {
            if (this.foodCollision()) {
                snake.grow();
                apple.spawn(snake);
            }
            else if (this.wallCollision() || this.selfCollision()) {
                graphics.current = "END";
            }
            else {
                snake.move();
            }
        }

    }


    @Override
    public void keyTyped(KeyEvent e) {
    }


    /**
     * This method implements the functionality
     * for when certain keys are pressed. When the
     * game is running and W,A, S, or D is pressed,
     * the snake moves up,left, down, or right respectively.
     * When the game isn't running, the game will start once
     * any key is pressed.
     */

    @Override
    public void keyPressed(KeyEvent key) {
        int keyCode = key.getKeyCode();

        if (graphics.current == "RUNNING") {

            if (keyCode == KeyEvent.VK_W && snake.getToMove() != "DOWN") {

                snake.up();

            }
            else if (keyCode == KeyEvent.VK_A && snake.getToMove() != "RIGHT") {

                snake.left();

            }
            else if (keyCode == KeyEvent.VK_S && snake.getToMove() != "UP") {

                snake.down();

            }
            else if (keyCode == KeyEvent.VK_D && snake.getToMove() != "LEFT") {

                snake.right();

            }

        }
        else {
            this.start();
        }

    }


    @Override
    public void keyReleased(KeyEvent e) {
    }


    /**
     * This method returns the snake
     * 
     * @return the snake
     */

    public Snake getSnake() {
        return snake;
    }


    /**
     * This method returns the food which I
     * refer to as an apple
     * 
     * @return the food/apple
     */

    public Food getApple() {
        return apple;
    }


    private boolean wallCollision() {

        if (snake.getX() < 0 || snake.getX() >= width * factor || snake
            .getY() < 0 || snake.getY() >= height * factor) {

            return true;

        }

        return false;
    }


    private boolean foodCollision() {

        if (snake.getX() == apple.getX() * factor && snake.getY() == apple
            .getY() * factor) {

            return true;

        }

        return false;

    }


    private boolean selfCollision() {

        for (int i = 1; i < snake.getBody().size(); i++) {

            if (snake.getX() == snake.getBody().get(i).getX() && snake
                .getY() == snake.getBody().get(i).getY()) {

                return true;

            }

        }

        return false;

    }

}
