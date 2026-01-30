package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import enums.ShapeType;
import enums.ToolType;
import models.Freehand;
import models.LineShape;
import models.MainShape;
import models.OvalShape;
import models.RectangleShape;

public class DrawingPanel extends JPanel {
    Stack<MainShape> shapes = new Stack<>();
    MainShape currentShape;

    public Color currentColor = Color.BLACK;
    public ShapeType shapeType = null;
    public ToolType tool = ToolType.FREE_HAND;
    public boolean filled = false;
    public boolean dotted = false;
    Point sPoint;
    private int w, h;

    public DrawingPanel() {

        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                sPoint = e.getPoint();

                if (tool == ToolType.FREE_HAND) {
                    currentShape = new Freehand(currentColor);
                    ((Freehand) currentShape).addPoint(e.getPoint());
                }
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if (tool == ToolType.FREE_HAND) {
                    ((Freehand) currentShape).addPoint(e.getPoint());
                } else {
                    w = e.getX() - sPoint.x;
                    h = e.getY() - sPoint.y;

                    switch (shapeType) {
                        case RECTANGLE:
                            currentShape = new RectangleShape(sPoint.x, sPoint.y, w, h, currentColor, filled, dotted);
                            break;
                        case OVAL:
                            currentShape = new OvalShape(sPoint.x, sPoint.y, w, h, currentColor, filled, dotted);
                            break;
                        case LINE:
                            currentShape = new LineShape(sPoint, e.getPoint(), currentColor, filled, dotted);
                        default:
                            break;
                    }
                }
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (currentShape != null) {
                    shapes.push(currentShape);
                    currentShape = null;
                    repaint();
                }
            }
        };

        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);
    }

    public void undo() {
        if (!shapes.isEmpty()) {
            shapes.pop();
            repaint();
        }
    }

    public void clear() {
        shapes.clear();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for(MainShape s : shapes){
            s.draw(g2);
        }

        if(currentShape !=null){
            currentShape.draw(g2);
        }

    }
}
