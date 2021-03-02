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
                new Point(-5, 0), 3, 4);


        Rectangle onTheRight = new Rectangle(
                new Point(1, 0), 3, 5);

        Assertions.assertFalse(onTheLeft.intersects(onTheRight));

    }

    @Test
    public void testContainment() {
        Rectangle r = new Rectangle(new Point(0,0), 5, 5);
        Assertions.assertTrue(r.contains(new Point(2,2)));
        Assertions.assertFalse(r.contains(new Point(-1,-1)));
        Assertions.assertTrue(r.contains(r.origin));
        Assertions.assertTrue(r.contains(new Point(r.origin.x+r.width, r.origin.y+r.height)));
    }

    @Test
    public void testBasicIntersection() {

        Rectangle onTheLeft = new Rectangle(
                new Point(-5, 0), 3, 4);

        Rectangle onTheRight = new Rectangle(
                new Point(-2, 0), 3, 8);


        Assertions.assertTrue(onTheLeft.intersects(onTheRight));

    }
}
