package com.grumpybucket.recruiting.rectangle;

import java.awt.Point;
import java.util.Objects;

/**
 * A 4 sided parallelogram with arbitrarily long sides. It is always wound clockwise from an origin point.
 */
public class Rectangle {

    //TODO: might there be a need to derive a relationship between 2 rectangles without having to check each one?

    public final Point origin;
    private Point topLeft;
    private Point topRight;
    private Point bottomRight;
    public final int width; //if java.awt.Point used floats, the dimensions would be floats instead.
    public final int height;

    /**
     *
     * @param origin The bottom left point of the rectangle
     * @param height
     * @param width
     */
    public Rectangle(Point origin, int height, int width) {

        this.origin = Objects.requireNonNull(origin, "Rectangle must have an origin");
        if(width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Dimensions "+height+","+width+" were supposed to be greater than zero");
        }
        this.topLeft = new Point(origin.x, origin.y+height);
        this.topRight = new Point(origin.x+width, origin.y+height);
        this.bottomRight = new Point( origin.x+width, origin.y);
        this.width = width;
        this.height = height;
    }

    /**
     *
     * @param intersectee
     * @return whether any of the supplied rectangle falls within this Rectangle.
     */
    //TODO: clarify with client if point overlap is sufficient, or if they intended this to only consider
    //edges that fall within it.
    public boolean intersects(Rectangle intersectee) {
        boolean iContainAnyOfIt = (this.contains(intersectee.origin) ||
                this.contains(intersectee.topLeft) ||
                this.contains(intersectee.topRight) ||
                this.contains(intersectee.bottomRight));
        boolean itContainsAnyOfMe = (intersectee.contains(this.origin) ||
                intersectee.contains(this.topLeft) ||
                intersectee.contains(this.topRight) ||
                intersectee.contains(this.bottomRight));
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

    public boolean contains(Rectangle subset) {
        return (this.contains(subset.origin) &&
                this.contains(subset.topLeft) &&
                this.contains(subset.topRight) &&
                this.contains(subset.bottomRight));
    }
}
