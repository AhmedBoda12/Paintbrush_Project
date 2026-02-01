package views;

import java.awt.*;

import javax.swing.JFrame;

public class PaintBrushFrame extends JFrame {

    public PaintBrushFrame() {

        setTitle("Paint Brush");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    
        setLayout(new BorderLayout());
    
        DrawingPanel drawingPanel = new DrawingPanel();
    
        add(new ToolsPanel(drawingPanel), BorderLayout.NORTH);
        add(drawingPanel, BorderLayout.CENTER);
        add(new BottomPanel(), BorderLayout.SOUTH);
    }
    

}
