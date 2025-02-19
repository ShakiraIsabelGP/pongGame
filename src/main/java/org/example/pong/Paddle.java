package org.example.pong;

import org.example.pong.lib.Vector;

public class Paddle {
    public Vector position;

    public Paddle(Vector position) {
        this.position = position;
    }
    public void draw(TerminalDisplay t) {
        t.putCharacter((int) Math.round(this.position.x), (int) Math.round(this.position.y), 'X');
    }
}
