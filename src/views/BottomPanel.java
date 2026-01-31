package views;
import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BottomPanel extends JPanel {
    JButton undoBtn, saveBtn, openBtn;

    public BottomPanel() {
        setLayout(new FlowLayout(FlowLayout.RIGHT));

        undoBtn = new JButton("Undo");
        saveBtn = new JButton("Save");
        openBtn = new JButton("Open");

        add(undoBtn);
        add(saveBtn);
        add(openBtn);
    }
   

}
