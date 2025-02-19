package org.example.pong;

import org.example.pong.lib.Vector;
import org.junit.Test;

import static org.junit.Assert.*;

public class BallTest {

    @Test
    public void updatePosition_changes_the_position_based_on_the_velocity_and_time() {
        Ball b = new Ball(new Vector(1, 5), new Vector(-1, 3));
        Vector expected = new Vector(-1, 11);

        b.updatePosition(2);

        assertEquals(expected, b.position);
    }

    @Test
    public void bounce_changes_the_direction_of_the_x_velocity_when_axis_is_x() {
        Ball b = new Ball(new Vector(1, 5), new Vector(-1, 3));

        b.bounce(Axis.X);

        assertEquals(1.0, b.velocity.x, 0.01);
    }

    @Test
    public void bounce_changes_the_direction_of_the_y_velocity_when_axis_is_y() {
        Ball b = new Ball(new Vector(1, 5), new Vector(-1, 3));

        b.bounce(Axis.Y);

        assertEquals(-3.0, b.velocity.y, 0.01);
    }
}