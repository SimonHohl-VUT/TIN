package cv3;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Joint extends GrObject {
    private final List<GrObject> children = new ArrayList<>();

    public Joint(int x, int y) {
        super(x, y);
    }

    public void add(GrObject obj) {
        children.add(obj);
    }

    @Override
    public void draw(Graphics g) {
        Graphics g2 = g.create();
        g2.translate(x, y);
        for (GrObject o : children) {
            o.draw(g2);
        }
        g2.dispose();
    }
}
