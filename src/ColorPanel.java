import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class ColorPanel extends JPanel {
    JToggleButton redBtn, greenBtn, blueBtn, blackBtn;
    JToggleButton rectBtn, ovalBtn, lineBtn;
    JButton resetBtn;
    JCheckBox dottedCheckBox, filledCheckBox;
    boolean selected = true;

    public ColorPanel() {

        setLayout(new FlowLayout(FlowLayout.CENTER));

        blackBtn = new JToggleButton();
        redBtn = new JToggleButton();
        greenBtn = new JToggleButton();
        blueBtn = new JToggleButton();

        rectBtn = new JToggleButton("Rectangle");
        ovalBtn = new JToggleButton("Oval");
        lineBtn = new JToggleButton("Line");

        resetBtn = new JButton("Reset");
        // TODO add implmentation of each button

        // Colors btns theme
        blackBtn.setBackground(Color.BLACK);
        redBtn.setBackground(Color.red);
        greenBtn.setBackground(Color.green);
        blueBtn.setBackground(Color.blue);
        ButtonGroup colorGroup = new ButtonGroup();
        colorGroup.add(blackBtn);
        colorGroup.add(redBtn);
        colorGroup.add(greenBtn);
        colorGroup.add(blueBtn);
        // Shape btns theme
        ButtonGroup shapeGroup = new ButtonGroup();
        shapeGroup.add(rectBtn);
        shapeGroup.add(ovalBtn);
        shapeGroup.add(lineBtn);

        // cheack buttons
        dottedCheckBox = new JCheckBox("Dotted");
        filledCheckBox = new JCheckBox("Filled");
        ButtonGroup checkGroup = new ButtonGroup();
        checkGroup.add(dottedCheckBox);
        checkGroup.add(filledCheckBox);

        add(new JLabel("Colors:"));
        add(blackBtn);
        add(redBtn);
        add(greenBtn);
        add(blueBtn);

        add(Box.createHorizontalStrut(20));

        add(new JLabel("Shapes:"));
        add(rectBtn);
        add(ovalBtn);
        add(lineBtn);
        add(dottedCheckBox);
        add(filledCheckBox);
        add(Box.createHorizontalStrut(100));
        add(resetBtn);

    }
}
