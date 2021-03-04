package com.grumpybucket.recruiting.rectangle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.Point;

public class ContainmentTest {

    @Test
    @DisplayName("disjoint rectangles don't contain each other")
    public void testNonContained() {
        Rectangle leftSide = new Rectangle(new Point(-5,-5), 2,2);
        Rectangle rightSide = new Rectangle(new Point(5,5), 2,2);

        Assertions.assertFalse(leftSide.contains(rightSide));
        Assertions.assertFalse(rightSide.contains(leftSide));
    }

    @Test
    @DisplayName("supersets contain subset")
    public void testContained() {
        Rectangle superSet = new Rectangle(new Point(0,0), 6,6);
        Rectangle subSet = new Rectangle(new Point(1,1),2,2);

        Assertions.assertTrue(superSet.contains(subSet));
    }

    @Test
    @DisplayName("partial containment doesn't count, is treated as intersection")
    public void partlyContained() {
        Rectangle leftSide = new Rectangle(new Point(0,0), 5,5);
        Rectangle rightSide = new Rectangle(new Point(4,2), 2,4);

        Assertions.assertFalse(leftSide.contains(rightSide));
        Assertions.assertTrue(leftSide.intersects(rightSide));
    }

    @Test
    @DisplayName("a rectangle can contain itself, or another of same size.")
    public void perfectlyContained() {
        Rectangle originSquare = new Rectangle(new Point(0,0), 1,1);
        Assertions.assertTrue(originSquare.contains(originSquare));

        Rectangle anotherOriginSquare = new Rectangle(new Point(0,0), 1,1);
        Assertions.assertTrue(anotherOriginSquare.contains(originSquare));
    }


}
