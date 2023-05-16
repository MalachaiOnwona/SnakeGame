package snakegame;

import java.awt.Rectangle;
import java.util.ArrayList;

/**
 * This class represents the snake
 * that will be controlled by the user
 * in the game window
 * 
 * @author Malachai Onwona
 * @version 05.16.2023
 */

public class Snake {

    private ArrayList<Rectangle> snakeBody;
    private int x = GameWindow.width;
    private int y = GameWindow.height;
    private int f = GameWindow.factor;

    /**
     * This string variable is used to keep
     * track of the direction that the snake
     * is moving in
     */
    public String toMove;

    /**
     * This constructor creates a Snake object and
     * creates the initial body parts of the Snake.
     * The snake starts out with three rectangles for
     * body parts, which are all linked through an
     * ArrayList. The toMove string is initialized as
     * well.
     */

    public Snake() {

        snakeBody = new ArrayList<>();

        Rectangle bodyPart = new Rectangle(f, f);
        bodyPart.setLocation(x / 2 * f, y / 2 * f);
        snakeBody.add(bodyPart);

        bodyPart = new Rectangle(f, f);
        bodyPart.setLocation((x / 2 - 1) * f, (y / 2) * f);
        snakeBody.add(bodyPart);

        bodyPart = new Rectangle(f, f);
        bodyPart.setLocation((x / 2 - 2) * f, (y / 2) * f);
        snakeBody.add(bodyPart);

        toMove = "NOTHING";

    }


    /**
     * This method returns the ArrayList
     * which represents the snakes body
     * 
     * @return the ArrayList representing
     *         the body of the snake
     */

    public ArrayList<Rectangle> getBody() {
        return snakeBody;
    }


    /**
     * This method allows for the snake to
     * move upward when called. The if statement
     * is there to make sure that the snake can't
     * move upward if it is already heading in the
     * downward.
     */

    public void up() {

        if (toMove != "DOWN") {

            toMove = "UP";

        }

    }


    /**
     * This method allows for the snake to
     * move leftward when called. The if statement
     * is there to make sure that the snake can't
     * move leftward if it is already heading to the
     * right.
     */

    public void left() {

        if (toMove != "RIGHT") {

            toMove = "LEFT";

        }

    }


    /**
     * This method allows for the snake to
     * move rightward when called. The if statement
     * is there to make sure that the snake can't
     * move rightward if it is already heading to the
     * left.
     */

    public void right() {

        if (toMove != "LEFT") {

            toMove = "RIGHT";

        }

    }


    /**
     * This method allows for the snake to
     * move downward when called. The if statement
     * is there to make sure that the snake can't
     * move downward if it is already heading upward.
     */

    public void down() {

        if (toMove != "UP") {

            toMove = "DOWN";

        }

    }


    /**
     * This method returns the x-coordinate
     * of the head of the snake.
     * 
     * @return the x-coordinate of the snake's
     *         head
     */

    public int getX() {
        return snakeBody.get(0).x;
    }


    /**
     * This method returns the y-coordinate
     * of the head of the snake.
     * 
     * @return the y-coordinate of the snake's
     *         head
     */

    public int getY() {
        return snakeBody.get(0).y;
    }


    /**
     * This method implements the functionality
     * for the snake's movement by changing the
     * x or y coordinate depending on what direction the
     * toMove string indicates. The snake moves by adding
     * a rectangle to the beginning of the ArrayList/head of
     * the snake and removing from the end of the ArrayList/snake's
     * body.
     */

    public void move() {

        if (toMove != "NOTHING") {

            Rectangle head = snakeBody.get(0);

            Rectangle temp = new Rectangle(GameWindow.factor,
                GameWindow.factor);

            if (toMove == "UP") {
                temp.setLocation(head.x, head.y - GameWindow.factor);
            }

            else if (toMove == "LEFT") {
                temp.setLocation(head.x - GameWindow.factor, head.y);
            }

            else if (toMove == "DOWN") {
                temp.setLocation(head.x, head.y + GameWindow.factor);
            }

            else if (toMove == "RIGHT") {
                temp.setLocation(head.x + GameWindow.factor, head.y);
            }

            snakeBody.add(0, temp);
            snakeBody.remove(snakeBody.size() - 1);

        }

    }


    /**
     * This method returns the string that
     * represents the direction of the snake's
     * movement
     * 
     * @return the string representing the
     *         direction of the snake's movement
     */

    public String getToMove() {
        return toMove;
    }


    /**
     * This method implements the functionality for
     * when the snake "eats" the food. When the snake's
     * head is at the same (x,y) point as the food, meaning
     * the snake ate the food, another rectangle/body part
     * is added to the head of the snake depending on which direction the
     * snake is moving in.
     */

    public void grow() {

        Rectangle head = snakeBody.get(0);

        Rectangle temp = new Rectangle(GameWindow.factor, GameWindow.factor);

        if (toMove == "UP") {
            temp.setLocation(head.x, head.y - GameWindow.factor);
        }

        else if (toMove == "LEFT") {
            temp.setLocation(head.x - GameWindow.factor, head.y);
        }

        else if (toMove == "DOWN") {
            temp.setLocation(head.x, head.y + GameWindow.factor);
        }

        else if (toMove == "RIGHT") {
            temp.setLocation(head.x + GameWindow.factor, head.y);
        }

        snakeBody.add(0, temp);

    }

}
