package com.grumpybucket.recruiting.rectangle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.Point;

public class ContainmentTest {

    @Test
    public void testNonContained() {
        Rectangle leftSide = new Rectangle(new Point(-5,-5), 2,2);
        Rectangle rightSide = new Rectangle(new Point(5,5), 2,2);

        Assertions.assertFalse(leftSide.contains(rightSide));
    }

    @Test
    public void testContained() {
        Rectangle superSet = new Rectangle(new Point(0,0), 6,6);
        Rectangle subSet = new Rectangle(new Point(1,1),2,2);

        Assertions.assertTrue(superSet.contains(subSet));
    }

    @Test
    public void partlyContained() {
        Rectangle leftSide = new Rectangle(new Point(0,0), 5,5);
        Rectangle rightSide = new Rectangle(new Point(4,2), 2,4);

        Assertions.assertFalse(leftSide.contains(rightSide));
        Assertions.assertTrue(leftSide.intersects(rightSide));
    }

    @Test
    public void perfectlyContained() {
        Rectangle originSquare = new Rectangle(new Point(0,0), 1,1);
        Assertions.assertTrue(originSquare.contains(originSquare));
    }

    
}
