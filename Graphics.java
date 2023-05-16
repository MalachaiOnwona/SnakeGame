package snakegame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * This class implements the visuals and
 * functionality of the game window itself
 * 
 * @author Malachai Onwona
 * @version 05.16.2023
 */

public class Graphics extends JPanel implements ActionListener {

    private Timer clock = new Timer(100, this);
    private Snake snake;
    private Food apple;
    private GameWindow game;
    public String current;

    /**
     * This constructor creates a Graphics
     * object and instantiates all the variables
     * declared at the beginning of the class. It starts
     * a timer which will basically refresh what you see on
     * the screen every 100 milliseconds and adds a key listener
     * which allows for the reception of a pressed keys input.
     * 
     * @param newGame
     *            The game window in which the graphics
     *            will be applied
     */

    public Graphics(GameWindow newGame) {

        clock.start();

        current = "START";

        game = newGame;
        snake = newGame.getSnake();
        apple = newGame.getApple();

        this.addKeyListener(newGame);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);

    }


    /**
     * This method repaints and updates the window
     * whenever an action is performed such as a
     * change in movement from the pressing of a key.
     */

    @Override
    public void actionPerformed(ActionEvent e) {

        repaint();

        game.update();

    }


    /**
     * This method designs the look for the window.
     * It colors the background and adds text for the
     * different results of the game.
     * 
     * @param graphic
     *            The graphic
     */

    public void paint(java.awt.Graphics graphic) {

        super.paintComponent(graphic);

        Graphics2D graphic2D = (Graphics2D)graphic;

        graphic2D.setColor(Color.darkGray);
        graphic2D.fillRect(0, 0, GameWindow.width * GameWindow.factor + 5,
            GameWindow.height * GameWindow.factor + 5);

        if (current == "START") {
            graphic2D.setColor(Color.WHITE);
            graphic2D.drawString("Press Any Key", GameWindow.width / 2
                * GameWindow.factor - 42, GameWindow.height / 2
                    * GameWindow.factor - 22);
        }
        else if (current == "RUNNING") {

            graphic2D.setColor(Color.RED);
            graphic2D.fillRect(apple.getX() * GameWindow.factor, apple.getY()
                * GameWindow.factor, GameWindow.factor, GameWindow.factor);

            graphic2D.setColor(Color.GREEN);
            for (Rectangle square : snake.getBody()) {

                graphic2D.fill(square);

            }

        }
        else {
            if ((snake.getBody().size() - 3) < 10) {

                graphic2D.setColor(Color.RED);

                graphic2D.drawString("Better Luck Next Time.", GameWindow.width
                    / 2 * GameWindow.factor - 50, GameWindow.height / 2
                        * GameWindow.factor + 5);

                graphic2D.drawString("Score: " + (snake.getBody().size() - 3),
                    GameWindow.width / 2 * GameWindow.factor - 15,
                    GameWindow.height / 2 * GameWindow.factor + 20);

            }
            else if ((snake.getBody().size() - 3) >= 10 && (snake.getBody()
                .size() - 3) < 25) {

                graphic2D.setColor(Color.GREEN);

                graphic2D.drawString("Wow!", GameWindow.width / 2
                    * GameWindow.factor - 5, GameWindow.height / 2
                        * GameWindow.factor + 5);

                graphic2D.drawString("Score: " + (snake.getBody().size() - 3),
                    GameWindow.width / 2 * GameWindow.factor - 15,
                    GameWindow.height / 2 * GameWindow.factor + 20);

            }
            else {

                graphic2D.setColor(Color.MAGENTA);

                graphic2D.drawString("Sensational!", GameWindow.width / 2
                    * GameWindow.factor - 22, GameWindow.height / 2
                        * GameWindow.factor + 5);

                graphic2D.drawString("Score: " + (snake.getBody().size() - 3),
                    GameWindow.width / 2 * GameWindow.factor - 15,
                    GameWindow.height / 2 * GameWindow.factor + 20);

            }
        }

    }

}
