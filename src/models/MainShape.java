package models;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

public abstract class MainShape {
    Color color;
    boolean isFilled;
    boolean isDotted;
    Stroke stroke;

    public MainShape(Color c, boolean f, boolean d) {
        color = c;
        isFilled = f;
        isDotted = d;

        if (isDotted) {
            stroke = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 9 }, 0);
        } else {
            stroke = new BasicStroke(2);
        }
    }

    public abstract void draw(Graphics2D g);

}
