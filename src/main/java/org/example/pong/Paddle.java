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
        for (int y = (int) getTopY(); y <= getBottomY(); y++) {
            t.putCharacter((int) Math.round(this.position.x), y, '|');
        }
    }

    public void moveUp() {
        if (position.y > height / 2)
            position.y--;
    }

    public void moveDown(TerminalDisplay t) {
        int maxY = t.getTerminalSize().getRows();
        if (getBottomY() < maxY)
            position.y++;
    }
}
