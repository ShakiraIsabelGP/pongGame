package org.example.pong.lib;

import static org.junit.Assert.*;
import org.junit.Test;

public class VectorTest {

    @Test
    public void plus_adds_two_vectors_together() {
        Vector a = new Vector(1, 1);
        Vector b = new Vector(-1, 6);
        Vector expected = new Vector(0, 7);

        Vector actual = a.plus(b);

        assertEquals(expected, actual);
    }

    @Test
    public void times_scales_the_vector_by_some_number() {
        Vector a = new Vector(1, 1);
        Vector expected = new Vector(6, 6);

        Vector actual = a.times(6);

        assertEquals(expected, actual);
    }
}
