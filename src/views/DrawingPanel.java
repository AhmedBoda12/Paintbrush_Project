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

    public DrawingPanel() {
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        initMouseListeners();
    }

    private void initMouseListeners() {
        MouseAdapter handler = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                sPoint = e.getPoint();
                if (tool == ToolType.FREE_HAND) {
                    currentShape = new Freehand(currentColor, false);
                    ((Freehand) currentShape).addPoint(sPoint);
                } else if (tool == ToolType.ERASER) {
                    currentShape = new Freehand(Color.white, true);
                    ((Freehand) currentShape).addPoint(sPoint);
                }
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if (tool == ToolType.FREE_HAND || tool == ToolType.ERASER) {
                    if (currentShape instanceof Freehand) {
                        ((Freehand) currentShape).addPoint(e.getPoint());
                    }
                } else if (tool == ToolType.SHAPE) {
                    currentShape = createShape(e.getPoint());
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

        addMouseListener(handler);
        addMouseMotionListener(handler);
    }

    private MainShape createShape(Point endPoint) {
        if (shapeType == null)
            return null;

        int x = Math.min(sPoint.x, endPoint.x);
        int y = Math.min(sPoint.y, endPoint.y);
        int width = Math.abs(sPoint.x - endPoint.x);
        int height = Math.abs(sPoint.y - endPoint.y);

        return switch (shapeType) {
            case RECTANGLE -> new RectangleShape(x, y, width, height, currentColor, filled, dotted);
            case OVAL -> new OvalShape(x, y, width, height, currentColor, filled, dotted);
            case LINE -> new LineShape(sPoint, endPoint, currentColor, filled, dotted);
        };
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

        for (MainShape s : shapes) {
            s.draw(g2);
        }

        if (currentShape != null) {
            currentShape.draw(g2);
        }

    }
}
