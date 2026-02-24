package cv3;

import java.awt.Graphics;

public class Circle extends GrObject {
    private int radius;

    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int r) {
        this.radius = r;
    }

    @Override
    public void draw(Graphics g) {
        g.drawOval(x - radius, y - radius, radius * 2, radius * 2);
    }
}
