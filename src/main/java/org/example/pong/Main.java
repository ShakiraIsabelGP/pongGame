package org.example.pong;

import com.googlecode.lanterna.TerminalSize;
import org.example.pong.lib.Vector;
import com.googlecode.lanterna.input.KeyStroke;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TerminalDisplay t = new TerminalDisplay();
        Ball b = new Ball(new Vector(3, 5), new Vector(-1, 6));
        TerminalSize size = t.getTerminalSize();
        int height = size.getRows();
        int width = size.getColumns();

        double fps = 30.0;
        double timeDelta = 1.0/fps;
        final long timeDeltaMs = (long) (timeDelta * 1000);
        System.out.println(timeDeltaMs);
        KeyStroke k;

        do {
            long start = System.currentTimeMillis();
            b.updatePosition(timeDelta);
            t.clear();


            if (b.position.x >= width || b.position.x <= 0)
                b.bounce(Axis.X);

            if (b.position.y >= height || b.position.y <= 0)
                b.bounce(Axis.Y);
            t.setCursorPosition((int) Math.round(b.position.x), (int) Math.round(b.position.y) );

            t.flush();
            long end = System.currentTimeMillis();
            long timeToRender = end-start;
            Thread.sleep(timeDeltaMs - timeToRender);
            k = t.getNextKeypress();

        } while (k == null || k.getCharacter() != 'q');
        System.exit(1);
    }
}
