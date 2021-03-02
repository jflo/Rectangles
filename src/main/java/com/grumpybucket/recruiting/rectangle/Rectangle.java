package com.grumpybucket.recruiting.rectangle;

import java.awt.Point;

public class Rectangle {

    public final Point origin;
    private Point b;
    private Point c;
    private Point d;
    public final int width; //if java.awt.Point used floats, the dimensions would be floats instead.
    public final int height;


    public Rectangle(Point origin, int height, int width) {

        this.origin = origin;
        this.b = new Point(origin.x, origin.y+height);
        this.c = new Point(origin.x+width, origin.y+height);
        this.d = new Point( origin.x+width, origin.y);
        this.width = width;
        this.height = height;
    }

    public boolean intersects(Rectangle intersectee) {
        boolean iContainAnyOfIt = (this.contains(intersectee.origin) ||
                this.contains(intersectee.b) ||
                this.contains(intersectee.c) ||
                this.contains(intersectee.d));
        boolean itContainsAnyOfMe = (intersectee.contains(this.origin) ||
                intersectee.contains(this.b) ||
                intersectee.contains(this.c) ||
                intersectee.contains(this.d));
        return (iContainAnyOfIt || itContainsAnyOfMe);
    }

    /**
     *
     * @param p
     * @return whether or not the supplied point falls within the rectangle
     */
    public boolean contains(Point p) {
        return (p.x >= origin.x && p.x <= origin.x+height && p.y >= origin.y && p.y <= origin.y+height);
    }
}
