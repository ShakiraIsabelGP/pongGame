package org.example.pong;

import com.googlecode.lanterna.TerminalSize;
import org.example.pong.lib.Vector;
import com.googlecode.lanterna.input.KeyStroke;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TerminalDisplay t = new TerminalDisplay();
        Ball b = new Ball(new Vector(3, 5), new Vector(-1, 3));
        TerminalSize size = t.getTerminalSize();
        int height = size.getRows();
        int width = size.getColumns();

        double timeDelta = 0.10;
        final long timeDeltaMs = (long) (timeDelta * 1000);
        KeyStroke k;

        do {
            b.updatePosition(timeDelta);

            if (b.position.x >= width || b.position.x <= 0)
                b.bounce(Axis.X);

            if (b.position.y >= height || b.position.y <= 0)
                b.bounce(Axis.Y);
            t.putCharacter((int) Math.round(b.position.x), (int) Math.round(b.position.y), '*');

            t.flush();
            Thread.sleep(timeDeltaMs);
            k = t.getNextKeypress();

        } while (k == null || k.getCharacter() != 'q');
        System.exit(1);
    }
}
