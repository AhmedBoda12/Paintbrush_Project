package models;

import java.awt.Color;
import java.awt.Graphics2D;

public class RectangleShape extends MainShape {
    int x, y, width, height;

    public RectangleShape(int x, int y, int w, int h, Color c, boolean f, boolean d) {
        super(c, f, d);

        this.x = x;
        this.y = y;
        width = w;
        height = h;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        g.setStroke(stroke);

        if (isFilled) {
            g.fillRect(x, y, width, height);
        } else {
            g.drawRect(x, y, width, height);
        }
    }

}
