package com.grumpybucket.recruiting.rectangle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.Point;

@DisplayName("Intersection Tests")
public class IntersectionTest {

    @Test
    public void testNonIntersection() {

        Rectangle onTheLeft = new Rectangle(
                new Point(-5, 0),
                new Point(-5, 3),
                new Point(-1, 3),
                new Point(-1, 0)
        );

        Rectangle onTheRight = new Rectangle(
                new Point(1, 0),
                new Point(1, 3),
                new Point(6, 3),
                new Point(6,0)
        );

        Assertions.assertFalse(onTheLeft.intersects(onTheRight));

    }
}
