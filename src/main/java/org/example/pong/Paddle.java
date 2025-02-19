package org.example.pong;

import org.example.pong.lib.Vector;

public class Paddle {
    public Vector position;
    public double height;

    public Paddle(Vector position, double height) {
        this.position = position;
        this.height = height;
    }

    public double getTopY() {
        return position.y - (height / 2);
    }

    public double getBottomY() {
        return position.y + (height / 2);
    }

    public boolean isBallCollidingPaddle(Ball ball) {
        if (isLeftPaddle() &&
                ball.position.x <= this.position.x &&
                ball.position.y >= getTopY() &&
                ball.position.y <= getBottomY() &&
                ball.velocity.x < 0)
            return true;
        if (!isLeftPaddle() &&
                ball.position.x >= this.position.x &&
                ball.position.y >= getTopY() &&
                ball.position.y <= getBottomY() &&
                ball.velocity.x > 0)
            return true;
        return false;

    }

    public boolean isLeftPaddle() {
        return position.x < 5;
    }

    public void draw(TerminalDisplay t) {
        t.putCharacter((int) Math.round(this.position.x), (int) Math.round(this.position.y), '|');
        t.flush();
    }

    public void moveUp(TerminalDisplay t) {
        int height = t.getTerminalSize().getRows();
        while (this.position.y < height) {
            t.putCharacter((int) Math.round(this.position.x), (int) Math.round(this.position.y) - 1, '|');
            t.flush();
        }
    }

    public void moveDown(TerminalDisplay t) {
        while (this.position.y > 0) {
            t.putCharacter((int) Math.round(this.position.x), (int) Math.round(this.position.y) + 1, '|');
            t.flush();
        }
    }


}
