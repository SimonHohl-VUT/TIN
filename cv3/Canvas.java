package cv3;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Canvas extends JPanel {
    private final List<GrObject> shapes = new ArrayList<>();

    public Canvas() {
        setBackground(Color.WHITE);
    }

    public void add(GrObject o) {
        shapes.add(o);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (GrObject o : shapes) {
            o.draw(g);
        }
    }
}
