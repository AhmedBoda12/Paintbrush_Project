package views;

import java.awt.*;

import javax.swing.JFrame;

public class PaintBrushFrame extends JFrame {

    public PaintBrushFrame() {

        setTitle("Paint Brush");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    
        setLayout(new BorderLayout());
    
        DrawingPanel drawingPanel = new DrawingPanel();
    
        add(new ColorPanel(drawingPanel), BorderLayout.NORTH);
        add(new ToolPanel(drawingPanel), BorderLayout.WEST);
        add(drawingPanel, BorderLayout.CENTER);
        add(new BottomPanel(), BorderLayout.SOUTH);
    }
    

}
