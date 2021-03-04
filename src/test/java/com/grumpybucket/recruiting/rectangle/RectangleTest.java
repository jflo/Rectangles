package com.grumpybucket.recruiting.rectangle;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

@DisplayName("Rectangle Validation")
public class RectangleTest{


        @Test
        @DisplayName("all squares are rectangles")
        public void testSquare() {
                Rectangle square = new Rectangle(new Point(0,0), 1,1);
        }

        @Test
        @DisplayName("Squares can have a mix of negative and positive coordinates")
        public void testSquareSpanningAxes() {
                Rectangle square = new Rectangle(new Point(-1,-1), 2, 2);
        }

        @Test
        @DisplayName("Rectangles can span horizontal (x) axis")
        public void testRectHorizSpanningAxes() {
                Rectangle rect = new Rectangle(new Point(-2, -1), 2,4);
        }


        @Test
        @DisplayName("Rectangles can span vertical (y) axis")
        public void testRectVertSpanningAxes() {
                Rectangle rect = new Rectangle( new Point(-1,-2), 3,2);
        }

        @Test
        @DisplayName("can tell if any point lies within a rectangle")
        public void testPointContainment() {
                Rectangle r = new Rectangle(new Point(0,0), 5, 5);
                Assertions.assertTrue(r.contains(new Point(2,2)));
                Assertions.assertFalse(r.contains(new Point(-1,-1)));
                Assertions.assertTrue(r.contains(r.origin));
                Assertions.assertTrue(r.contains(new Point(r.origin.x+r.width, r.origin.y+r.height)));
        }

        @Test
        @DisplayName("throw exception on invalid constructor values")
        public void testBogusConstruction() {
                Assertions.assertThrows(NullPointerException.class, () -> {
                        Rectangle r = new Rectangle(null, 1,1);
                        }
                );
                Assertions.assertThrows(IllegalArgumentException.class, () -> {
                                Rectangle r = new Rectangle(new Point(0,0), 0,1);
                        }
                );
                Assertions.assertThrows(IllegalArgumentException.class, () -> {
                                Rectangle r = new Rectangle(new Point(0,0), 1,0);
                        }
                );
                Assertions.assertThrows(IllegalArgumentException.class, () -> {
                                Rectangle r = new Rectangle(new Point(0,0), 0,0);
                        }
                );
                Assertions.assertThrows(IllegalArgumentException.class, () -> {
                                Rectangle r = new Rectangle(new Point(0,0), 0,-1);
                        }
                );
                Assertions.assertThrows(IllegalArgumentException.class, () -> {
                                Rectangle r = new Rectangle(new Point(0,0), -1,0);
                        }
                );
                Assertions.assertThrows(IllegalArgumentException.class, () -> {
                                Rectangle r = new Rectangle(new Point(0,0), -1,-1);
                        }
                );


        }

}
