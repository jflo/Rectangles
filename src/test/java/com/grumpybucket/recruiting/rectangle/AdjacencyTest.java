package com.grumpybucket.recruiting.rectangle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class AdjacencyTest {
    @Test
    public void testNotAdjacent() {
        Rectangle leftSide = new Rectangle(new Point(-2,0), 1, 1);
        Rectangle rightSide = new Rectangle(new Point(1,0), 1,1);

        Assertions.assertFalse(leftSide.adjacentTo(rightSide));
    }

    @Test
    public void testAdjacentIntersected() {
        Rectangle leftSide = new Rectangle(new Point(0,0), 2, 3);
        Rectangle rightSide = new Rectangle(new Point(2,0), 2, 3);

        Assertions.assertFalse(leftSide.adjacentTo(rightSide));
    }

    @Test
    public void testProperAdjacent() {
        Rectangle leftSide = new Rectangle(new Point(-1,0), 1,1);
        Rectangle rightSide = new Rectangle(new Point(0,0), 1,1);

        Assertions.assertTrue(leftSide.adjacentTo(rightSide));

        Rectangle top = new Rectangle(new Point(0,2), 2,2);
        Rectangle bottom = new Rectangle(new Point(0,0), 2,2);

        Assertions.assertTrue(top.adjacentTo(bottom));
    }

    @Test
    public void testSubLineAdjacent() {
        Rectangle leftSide = new Rectangle(new Point(0,0), 4,4);
        Rectangle rightSide = new Rectangle(new Point (4,1), 2,2);

        Assertions.assertTrue(leftSide.adjacentTo(rightSide));
    }

    @Test
    public void testPartialAdjacent() {
        Rectangle leftSide = new Rectangle(new Point(0,0), 4,4);
        Rectangle rightSide = new Rectangle(new Point(4,2), 4,4);

        Assertions.assertTrue(leftSide.adjacentTo(rightSide));
    }
}
