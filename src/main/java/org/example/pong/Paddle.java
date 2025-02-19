package org.example.pong;

import org.example.pong.lib.Vector;

public class Paddle {
    public Vector position;

    public Paddle(Vector position) {
        this.position = position;
    }

    public void draw(TerminalDisplay t) {
        t.putCharacter((int) Math.round(this.position.x), (int) Math.round(this.position.y), '|');
        t.flush();
    }

    public void moveUp(TerminalDisplay t) {
        int height = t.getTerminalSize().getRows();
        while (this.position.y < height) {
            t.clear();
            t.putCharacter((int) Math.round(this.position.x), (int) Math.round(this.position.y) - 1, '|');
            t.flush();
        }
    }

    public void moveDown(TerminalDisplay t) {
        while (this.position.y > 0) {
            t.putCharacter((int) Math.round(this.position.x), (int) Math.round(this.position.y) + 1, '|');
        }
    }


}
