package com.grumpybucket.recruiting.rectangle;

import com.sun.source.tree.AssertTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.Point;
import java.util.Optional;

@DisplayName("Intersection Tests")
public class IntersectionTest {

    @Test
    @DisplayName("disjoint rectangles do not intersect")
    public void testNonIntersection() {

        Rectangle onTheLeft = new Rectangle(
                new Point(-5, 0), 3, 4);

        Rectangle onTheRight = new Rectangle(
                new Point(1, 0), 3, 5);

        Assertions.assertFalse(onTheLeft.intersects(onTheRight));

    }



    @Test
    @DisplayName("overlapping rectangles intersect")
    public void testIsIntersected() {

        Rectangle onTheLeft = new Rectangle(
                new Point(-5, 0), 3, 8);

        Rectangle onTheRight = new Rectangle(
                new Point(-2, -2), 3, 4);


       boolean intersected = onTheLeft.intersects(onTheRight);
        Assertions.assertTrue(intersected);
    }

    @Test
    @DisplayName("size and position of intersection rectangle")
    public void testBasicIntersection() {

        Rectangle onTheLeft = new Rectangle(
                new Point(-5, 0), 3, 8);

        Rectangle onTheRight = new Rectangle(
                new Point(-2, -2), 3, 4);


        Optional<Rectangle> intersection = onTheLeft.intersectedBy(onTheRight);
        Assertions.assertNotNull(intersection);
        Assertions.assertEquals(-2, intersection.get().origin.x);
        Assertions.assertEquals(0, intersection.get().origin.y);
        Assertions.assertEquals(1, intersection.get().height);
        Assertions.assertEquals(4, intersection.get().width);
    }

    @Test
    @DisplayName("fully enclosed rectangles intersection is itself")
    public void testContainedIntersection() {
        Rectangle superset = new Rectangle(
                new Point(0, 0), 3, 3);

        Rectangle subset = new Rectangle(
                new Point(1, 1), 1, 1);

        Assertions.assertTrue(superset.intersects(subset));

        Optional<Rectangle> intersection = superset.intersectedBy(subset);
        Assertions.assertNotNull(intersection);
        Assertions.assertEquals(1, intersection.get().origin.x);
        Assertions.assertEquals(1, intersection.get().origin.y);
        Assertions.assertEquals(1, intersection.get().height);
        Assertions.assertEquals(1, intersection.get().width);
    }

    @Test
    @DisplayName("partial intersection results in subsection")
    public void testIncompleteEdgeIntersection() {
        //TODO: i'm not sure if the client wants this, reverse this test if they don't.
        Rectangle atOrigin = new Rectangle(new Point(0,0), 2,2);
        Rectangle downAndLeft = new Rectangle(new Point(-1,-1), 2,2);

        Assertions.assertTrue(atOrigin.intersects(downAndLeft));
        Optional<Rectangle> intersection = atOrigin.intersectedBy(downAndLeft);
        Assertions.assertNotNull(intersection);
        Assertions.assertEquals(0, intersection.get().origin.x);
        Assertions.assertEquals(0, intersection.get().origin.y);
        Assertions.assertEquals(1, intersection.get().height);
        Assertions.assertEquals(1, intersection.get().width);
    }

    @Test
    @DisplayName("overlapping with the same size, is an intersection of that size")
    public void testPerfectOverlap() {
        Rectangle r1 = new Rectangle(new Point(0,0), 5,5);
        Rectangle r2 = new Rectangle(new Point(0,0), 5,5);
        //TODO: check with client if this is right
        Assertions.assertTrue(r1.intersects(r2));
        Optional<Rectangle> intersection = r1.intersectedBy(r2);
        Assertions.assertNotNull(intersection);
        Assertions.assertEquals(0, intersection.get().origin.x);
        Assertions.assertEquals(0, intersection.get().origin.y);
        Assertions.assertEquals(5, intersection.get().height);
        Assertions.assertEquals(5, intersection.get().width);
    }

}
