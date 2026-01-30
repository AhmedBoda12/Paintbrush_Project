package views;

import java.awt.*;

import javax.swing.JFrame;

public class PaintBrushFrame extends JFrame {

    public PaintBrushFrame() {

        setTitle("Paint Brush");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        add(new ColorPanel(), BorderLayout.NORTH);
        add(new ToolPanel(), BorderLayout.WEST);
        add(new DrawingPanel(), BorderLayout.CENTER);
        add(new BottomPanel(), BorderLayout.SOUTH);
    }

}
