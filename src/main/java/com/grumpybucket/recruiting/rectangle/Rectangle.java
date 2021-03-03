package com.grumpybucket.recruiting.rectangle;

import java.awt.Point;
import java.util.*;

/**
 * A 4 sided parallelogram with arbitrarily long sides. It is always wound clockwise from an origin point.
 */
public class Rectangle {

    //TODO: might there be a need to derive a relationship between 2 rectangles without having to check each one?
    //future feature could be a static method that takes 2 rectangles, and tells you how they relate

    public final Point origin;
    private Point topLeft;
    private Point topRight;
    private Point bottomRight;
    public final int width; //if java.awt.Point used floats, the dimensions would be floats instead.
    public final int height;
    private final List<LineSegment> sides = Arrays.asList(new LineSegment[4]); //rectangles always have 4 sides, wound from the origin

    private final Map<Integer, Integer> opposingSides = new HashMap<Integer, Integer>();
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

        sides.set(0, new LineSegment(this.origin, this.topLeft));
        sides.set(1, new LineSegment(this.topLeft, this. topRight));
        sides.set(2, new LineSegment(this.topRight, this.bottomRight));
        sides.set(3, new LineSegment(this.bottomRight, this.origin));

        opposingSides.put(0,2); //todo ask a peer if there is some math i'm missing to not need to map this....
        opposingSides.put(1,3);
        opposingSides.put(2,0);
        opposingSides.put(3,1);
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

    /**
     * Two rectangles are adjacent if they each have an alternate side, of the same slope, sharing the same slopedposition
     * @param adjoinee
     * @return
     */
    public boolean adjacentTo(Rectangle adjoinee) {
        //for each of my sides, is there a side on the adjoinee with the same slope, at the same location?
        //comparing even sides depends on the x coord, odd sides the y

        //normally i would iterate with streams, but in this case i need to do useful things with the iteration value
        for(int i=0; i<this.sides.size(); i++) {
            if(i % 2 == 0) { //evens are vertical sides, compare x vals
                if(this.sides.get(i).to.x == adjoinee.sides.get(opposingSides.get(i)).to.x) {
                    //trust that the from and to points are aligned
                    return true;
                }
            } else { //odds are horizontal sides, compare y vals
                if(this.sides.get(i).to.y == adjoinee.sides.get(opposingSides.get(i)).to.y) {
                    return true;
                }
            }
        }

        return false;
    }


}
