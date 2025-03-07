package org.example.pong;

import com.googlecode.lanterna.TerminalSize;
import org.example.pong.lib.Vector;
import com.googlecode.lanterna.input.KeyStroke;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TerminalDisplay t = new TerminalDisplay();
        Ball b = new Ball(new Vector(3, 5), new Vector(30, 6));
        TerminalSize size = t.getTerminalSize();
        int height = size.getRows();
        int width = size.getColumns();
        Paddle playerOne = new Paddle(new Vector(2, height / 2.0), 5);
        Paddle playerTwo = new Paddle(new Vector(width - 2, height / 2.0), 5);

        double fps = 30.0;
        double timeDelta = 1.0 / fps;
        final long timeDeltaMs = (long) (timeDelta * 1000);
        System.out.println(timeDeltaMs);
        KeyStroke k;

        do {
            long start = System.currentTimeMillis();

            b.updatePosition(timeDelta);
            t.clear();
            playerOne.draw(t);
            playerTwo.draw(t);

            if (b.position.x >= width || b.position.x <= 0) {
                System.out.println("You lose!! :(");
                System.exit(1);
            }

            if (b.position.y >= height || b.position.y <= 0)
                b.bounce(Axis.Y);

            if (playerOne.isBallCollidingPaddle(b) || playerTwo.isBallCollidingPaddle(b)) {
                b.bounce(Axis.X);
            }

            k = t.getNextKeypress();
            if (k != null)
                switch (k.getCharacter()) {
                    case 'w':
                        playerOne.moveUp();
                        break;
                    case 's':
                        playerOne.moveDown(t);
                        break;
                    case 'k':
                        playerTwo.moveUp();
                        break;
                    case 'j':
                        playerTwo.moveDown(t);
                        break;
                }

            t.setCursorPosition((int) Math.round(b.position.x), (int) Math.round(b.position.y));

            t.flush();
            long end = System.currentTimeMillis();
            long timeToRender = end - start;

            Thread.sleep(Math.max(0, timeDeltaMs - timeToRender));


        }
        while (k == null || k.getCharacter() != 'q');
        System.exit(1);
    }
}
