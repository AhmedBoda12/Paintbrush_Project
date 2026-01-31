package views;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import enums.ToolType;

public class ToolPanel extends JPanel {
    JToggleButton freeHandBtn, eraserBtn;
    JButton clearBtn;
    
    DrawingPanel drawingPanel;

    public ToolPanel(DrawingPanel drawingPanel) {
        this.drawingPanel = drawingPanel;
    
        
        setLayout(new FlowLayout(FlowLayout.CENTER));

        // setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(150, 0));

        // Tool btns theme
        freeHandBtn = new JToggleButton("Free Hand");
        eraserBtn = new JToggleButton("Eraser");
        clearBtn = new JButton("Clear All");
        ButtonGroup toolGroup = new ButtonGroup();
        toolGroup.add(freeHandBtn);
        toolGroup.add(eraserBtn);


       

        // TODO add implmentation of each button

        add(Box.createHorizontalStrut(110));
        add(freeHandBtn);
        add(Box.createHorizontalStrut(120));
        add(eraserBtn);
        add(Box.createHorizontalStrut(140));
        add(clearBtn);
      add(Box.createHorizontalStrut(150));
add(new JLabel("Tools:"));
// add(freeHandBtn);
// add(eraserBtn);
// add(clearBtn);
freeHandBtn.addActionListener(e -> drawingPanel.tool = ToolType.FREE_HAND);

eraserBtn.addActionListener(e -> drawingPanel.tool = ToolType.ERASER);

clearBtn.addActionListener(e -> drawingPanel.clear());



        
    }
}
