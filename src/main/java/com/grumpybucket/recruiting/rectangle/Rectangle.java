package com.grumpybucket.recruiting.rectangle;

import java.awt.Point;

public class Rectangle {

    private Point a;
    private Point b;
    private Point c;
    private Point d;

    /**
     * A Rectangle is a clockwise wound array of points
     * @param a
     * @param b
     * @param c
     * @param d
     */
    public Rectangle(Point a, Point b, Point c, Point d) {

        if(Rectangle.slope(a, b) == Rectangle.slope(c, d)) {
            if(Rectangle.slope(b, c) == Rectangle.slope(d, a)) {
                this.a = a;
                this.b = b;
                this.c = c;
                this.d = d;
            } else {
                throw new IllegalArgumentException("non parallel sides detected");
            }
        } else {
            throw new IllegalArgumentException("non parallel sides detected");
        }
    }

    public static float slope(Point a, Point b) {
        if(b.x - a.x == 0) {
            return 0; //to avoid dividing by zero.
        }
        return (b.y - a.y)/(b.x - a.x);
    }

    public boolean intersects(Rectangle onTheRight) {
        return false;
    }
}
