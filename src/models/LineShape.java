package models;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class LineShape extends MainShape {

    Point sPoint, ePoint;

    public LineShape(Point s, Point e, Color c, boolean f, boolean d) {
        super(c, f, d);
        sPoint = s;
        ePoint = e;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        g.setStroke(stroke);
        g.drawLine(sPoint.x, sPoint.y, ePoint.x, ePoint.y);

    }

}
