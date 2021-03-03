package com.grumpybucket.recruiting.rectangle;

import javax.sound.sampled.Line;
import java.awt.*;

public class LineSegment {

    public final Point from;
    public final Point to;
    public final float slope;

    public LineSegment(Point from, Point to) {
        this.from = from;
        this.to = to;

        int rise = from.y+to.y;
        int run = from.x+to.x;
        if(run != 0) {
            this.slope = rise / run;
        } else {
            this.slope = 0;
        }
    }
}
