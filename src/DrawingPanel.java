import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel {
    
    public DrawingPanel() {
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
