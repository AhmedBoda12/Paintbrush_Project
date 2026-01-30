package models;

import java.awt.Color;
import java.awt.Graphics2D;

public class OvalShape extends MainShape {
    int x, y, width, height;

    public OvalShape(int x, int y, int w, int h, Color c, boolean f, boolean d) {
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

        if (isFilled)
            g.fillOval(x, y, width, height);
        else
            g.drawOval(x, y, width, height);
    }

}
