package views;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class ToolPanel extends JPanel {
    JToggleButton freeHandBtn, eraserBtn;
    JButton clearBtn;
    

    public ToolPanel() {
        setBackground(Color.GREEN);
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

        add(Box.createVerticalStrut(10));
        add(freeHandBtn);
        add(Box.createVerticalStrut(10));
        add(eraserBtn);
        add(Box.createVerticalStrut(10));
        add(clearBtn);

        
    }
}
