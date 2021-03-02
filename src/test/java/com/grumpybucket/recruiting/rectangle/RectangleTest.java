package com.grumpybucket.recruiting.rectangle;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("Rectangle Validation")
public class RectangleTest{
        @Test
        public void testSquareWoundFromBottomLeft() {
                Rectangle square = new Rectangle(
                        new Point(0,0),
                        new Point(0,1),
                        new Point(1,1),
                        new Point(1,0));
        }

        @Test
        public void testSquareWoundFromTopLeft() {
                Rectangle square = new Rectangle(
                  new Point(0,1),
                  new Point(1,1),
                  new Point(1,0),
                  new Point(0,0)
                );
        }

        @Test
        public void testSquareWoundFromTopRight() {
                Rectangle square = new Rectangle(
                        new Point(1,1),
                        new Point(1,0),
                        new Point(0,0),
                        new Point(0,1)
                );
        }

        @Test
        public void testSquareWoundFromBottomRight() {
                Rectangle square = new Rectangle(
                        new Point(1,0),
                        new Point(0,0),
                        new Point(0,1),
                        new Point(1,1)
                );
        }

        @Test
        public void testSquareWoundBelowOrigin(){
                Rectangle square = new Rectangle(
                        new Point(0, -1),
                        new Point(0,0),
                        new Point(1,0),
                        new Point(1, -1)
                );
        }

        @Test
        public void testSquareWoundBelowAndLeftOfOrigin() {
                Rectangle square = new Rectangle(
                        new Point(-1, -1),
                        new Point(-1,0),
                        new Point(0,0),
                        new Point(0,-1)
                );
        }

        @Test
        public void testSquareSpanningAxes() {
                Rectangle square = new Rectangle(
                        new Point(-1,-1),
                        new Point(-1,1),
                        new Point(1,1),
                        new Point(1, -1)
                );
        }

        @Test
        public void testRectHorizSpanningAxes() {
                Rectangle rect = new Rectangle(
                        new Point(-2, -1),
                        new Point(-2, 1),
                        new Point(2,1),
                        new Point(2, -1)
                );
        }


        @Test
        public void testRectVertSpanningAxes() {
                Rectangle rect = new Rectangle(
                        new Point(-1,-2),
                        new Point(-1, 2),
                        new Point(1, 2),
                        new Point( 1, -1)
                );
        }

        @Test
        public void testIllegalArgOutOfParallel() {
                Assertions.assertThrows(IllegalArgumentException.class, () -> {
                Rectangle trapezoid = new Rectangle(
                        new Point(-2, -1),
                        new Point(-1, 1),
                        new Point(1, 1),
                        new Point(2, -1)
                );});
        }

        @Test
        public void testMisWinding() {
                Assertions.assertThrows(IllegalArgumentException.class, () -> {
                        Rectangle rect = new Rectangle(
                                new Point(-1,-1),
                                new Point(1,1),
                                new Point(1,-1),
                                new Point(-1,1)
                        );
                });

        }

}
