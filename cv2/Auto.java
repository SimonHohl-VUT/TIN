package cv2;

public class Auto {
    private String nazev;
    private int x;
    private int y;

    public Auto(String nazev, int x, int y) {
        this.nazev = nazev;
        this.x = x;
        this.y = y;
    }

    public String getNazev() {
        return nazev;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    @Override
    public String toString() {
        return "Auto: " + nazev + " [" + x + "," + y + "]";
    }
}
