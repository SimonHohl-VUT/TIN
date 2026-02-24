package cv3;

import java.awt.Graphics;

public class Square extends GrObject {
    private int side;

    public Square(int x, int y, int side) {
        super(x, y);
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int s) {
        this.side = s;
    }

    @Override
    public void draw(Graphics g) {
        int half = side / 2;
        g.drawRect(x - half, y - half, side, side);
    }
}
