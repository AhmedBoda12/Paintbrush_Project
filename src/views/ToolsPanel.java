package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import enums.ShapeType;
import enums.ToolType;

public class ToolsPanel extends JPanel {
    JToggleButton redBtn, greenBtn, blueBtn, blackBtn;
    JToggleButton rectBtn, ovalBtn, lineBtn;
    JButton resetBtn;
    JCheckBox dottedCheckBox, filledCheckBox;
    JToggleButton freeHandBtn, eraserBtn;
    JButton clearBtn;
    DrawingPanel drawingPanel;

    public ToolsPanel(DrawingPanel drawingPanel) {
        this.drawingPanel = drawingPanel;
        setLayout(new FlowLayout(FlowLayout.CENTER));
        ButtonGroup buttonGroup = new ButtonGroup();
        initColors();
        addSepce(20);
        initTools(buttonGroup);
        addSepce(20);
        initShapes(buttonGroup);
        addSepce(100);

        resetBtn = new JButton("Reset");
        resetBtn.addActionListener(e -> resetButtons());
        add(resetBtn);
    }

    private void initColors() {
        add(new JLabel("Colors:"));
        ButtonGroup colorGroup = new ButtonGroup();

        blackBtn = createColorButton(Color.BLACK, colorGroup);
        redBtn = createColorButton(Color.RED, colorGroup);
        greenBtn = createColorButton(Color.GREEN, colorGroup);
        blueBtn = createColorButton(Color.BLUE, colorGroup);

        blackBtn.setSelected(true);
    }

    private void initTools(ButtonGroup toolGroup) {
        add(new JLabel("Tools:"));

        freeHandBtn = createToolButton("Free Hand", toolGroup, e -> drawingPanel.tool = ToolType.FREE_HAND);
        eraserBtn = createToolButton("Eraser", toolGroup, e -> drawingPanel.tool = ToolType.ERASER);

        clearBtn = new JButton("Clear All");
        clearBtn.addActionListener(e -> drawingPanel.clear());

        add(freeHandBtn);
        add(eraserBtn);
        add(clearBtn);

        freeHandBtn.setSelected(true);
    }

    private void initShapes(ButtonGroup shapeGroup) {
        add(new JLabel("Shapes:"));

        rectBtn = createShapeButton("Rectangle", ShapeType.RECTANGLE, shapeGroup);
        ovalBtn = createShapeButton("Oval", ShapeType.OVAL, shapeGroup);
        lineBtn = createShapeButton("Line", ShapeType.LINE, shapeGroup);

        dottedCheckBox = new JCheckBox("Dotted");
        filledCheckBox = new JCheckBox("Filled");
        dottedCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                drawingPanel.dotted = dottedCheckBox.isSelected();
                if (dottedCheckBox.isSelected()) {
                    drawingPanel.filled = !dottedCheckBox.isSelected();
                    filledCheckBox.setSelected(!dottedCheckBox.isSelected());
                }

            }
        });
        filledCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                drawingPanel.filled = filledCheckBox.isSelected();
                if (filledCheckBox.isSelected()) {
                    drawingPanel.dotted = !filledCheckBox.isSelected();
                    dottedCheckBox.setSelected(!filledCheckBox.isSelected());
                }

            }
        });
        // fillDottedGroup.add(dottedCheckBox);
        // fillDottedGroup.add(filledCheckBox);

        add(rectBtn);
        add(ovalBtn);
        add(lineBtn);
        add(dottedCheckBox);
        add(filledCheckBox);
    }

    private void resetButtons() {
        blackBtn.setSelected(true);
        freeHandBtn.setSelected(true);
        dottedCheckBox.setSelected(false);
        filledCheckBox.setSelected(false);
        drawingPanel.currentColor = Color.BLACK;
        drawingPanel.tool = ToolType.FREE_HAND;
        drawingPanel.shapeType = null;
        drawingPanel.dotted = false;
        drawingPanel.filled = false;
    }

    private JToggleButton createColorButton(Color color, ButtonGroup group) {
        JToggleButton btn = new JToggleButton();
        btn.setBackground(color);
        btn.setPreferredSize(new Dimension(20, 20));
        btn.addActionListener(e -> drawingPanel.currentColor = color);
        group.add(btn);
        add(btn);
        return btn;
    }

    private JToggleButton createToolButton(String text, ButtonGroup group, java.awt.event.ActionListener listener) {
        JToggleButton btn = new JToggleButton(text);
        btn.addActionListener(listener);
        group.add(btn);
        return btn;
    }

    private JToggleButton createShapeButton(String text, ShapeType type, ButtonGroup group) {
        JToggleButton btn = new JToggleButton(text);
        btn.addActionListener(e -> {
            drawingPanel.tool = ToolType.SHAPE;
            drawingPanel.shapeType = type;
        });
        group.add(btn);
        return btn;
    }

    private void addSepce(int width) {
        add(Box.createHorizontalStrut(width));
    }
}
