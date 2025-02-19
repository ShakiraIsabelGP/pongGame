package org.example.pong;

import org.example.pong.lib.Vector;

public class Ball {
    public Vector position;
    public Vector velocity;

    public Ball(Vector position, Vector velocity) {
        this.position = position;
        this.velocity = velocity;
    }

    public void updatePosition(double t) {
        position = position.plus(velocity.times(t));
    }

    public void bounce(Axis a) {
        if (a == Axis.X)
            velocity.x = -velocity.x;
        else
            velocity.y = -velocity.y;
    }
}

