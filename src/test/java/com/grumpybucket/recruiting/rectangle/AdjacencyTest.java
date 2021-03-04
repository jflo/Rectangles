package com.grumpybucket.recruiting.rectangle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class AdjacencyTest {
    @Test
    @DisplayName("disconnected rectangles are not adjacent")
    public void testNotAdjacent() {
        Rectangle leftSide = new Rectangle(new Point(-2,0), 1, 1);
        Rectangle rightSide = new Rectangle(new Point(1,0), 1,1);

        Assertions.assertFalse(leftSide.adjacentTo(rightSide));
    }

    @Test
    @DisplayName("intersected rectangles are never adjacent")
    public void testAdjacentIntersected() {
        Rectangle leftSide = new Rectangle(new Point(0,0), 2, 3);
        Rectangle rightSide = new Rectangle(new Point(2,0), 2, 3);
        Assertions.assertTrue(leftSide.intersects(rightSide));
        Assertions.assertFalse(leftSide.adjacentTo(rightSide));
    }

    @Test
    @DisplayName("sides with same length side are adjacent")
    public void testProperAdjacent() {
        Rectangle leftSide = new Rectangle(new Point(-1,0), 1,1);
        Rectangle rightSide = new Rectangle(new Point(0,0), 1,1);

        Assertions.assertTrue(leftSide.adjacentTo(rightSide));

        Rectangle top = new Rectangle(new Point(0,2), 2,2);
        Rectangle bottom = new Rectangle(new Point(0,0), 2,2);

        Assertions.assertTrue(top.adjacentTo(bottom));
    }

    @Test
    @DisplayName("one side shorter than the other can be adjacent")
    public void testSubLineAdjacent() {
        Rectangle leftSide = new Rectangle(new Point(0,0), 4,4);
        Rectangle rightSide = new Rectangle(new Point (4,1), 2,2);

        Assertions.assertTrue(leftSide.adjacentTo(rightSide));
    }

    @Test
    @DisplayName("sides with mismatched ends can be adjacent")
    public void testPartialAdjacent() {
        Rectangle leftSide = new Rectangle(new Point(0,0), 4,4);
        Rectangle rightSide = new Rectangle(new Point(4,2), 4,4);

        Assertions.assertTrue(leftSide.adjacentTo(rightSide));
    }
}
