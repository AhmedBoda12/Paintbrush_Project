package models;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

public class Freehand extends MainShape {

    ArrayList<Point> points = new ArrayList<Point>();

    public Freehand(Color c) {
        super(c, false, false);
    }

    public void addPoint(Point p){
        points.add(p);
    }

    @Override
    public void draw(Graphics2D g) {
       g.setColor(color);
       g.setStroke(new BasicStroke(2));

        for (int i = 0; i < points.size() - 1; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }

}
