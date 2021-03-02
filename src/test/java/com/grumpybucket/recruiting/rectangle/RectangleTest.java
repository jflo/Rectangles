package com.grumpybucket.recruiting.rectangle;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("Rectangle Validation")
public class RectangleTest{
        @Test
        public void testSquare() {
                Rectangle square = new Rectangle(new Point(0,0), 1,1);
        }

        @Test
        public void testSquareWoundBelowOrigin(){
                Rectangle square = new Rectangle( new Point(0, -1), 1, 1);
        }

        @Test
        public void testSquareWoundBelowAndLeftOfOrigin() {
                Rectangle square = new Rectangle( new Point(-1, -1), 1,1);
        }

        @Test
        public void testSquareSpanningAxes() {
                Rectangle square = new Rectangle(new Point(-1,-1), 2, 2);
        }

        @Test
        public void testRectHorizSpanningAxes() {
                Rectangle rect = new Rectangle(new Point(-2, -1), 2,4);
        }


        @Test
        public void testRectVertSpanningAxes() {
                Rectangle rect = new Rectangle( new Point(-1,-2), 3,2);
        }

        @Test
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
