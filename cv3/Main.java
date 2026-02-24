package cv3;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        java.util.List<GrObject> shapes = new java.util.ArrayList<>();

        shapes.add(new Square(300, 100, 80));

        Joint face = new Joint(200, 200);
        face.add(new Circle(0, 0, 60));
        Joint leftEye = new Joint(-20, -20);
        leftEye.add(new Circle(0, 0, 10));
        leftEye.add(new Circle(0, 0, 5));
        Joint rightEye = new Joint(20, -20);
        rightEye.add(new Circle(0, 0, 10));
        rightEye.add(new Circle(0, 0, 5));
        face.add(leftEye);
        face.add(rightEye);
        face.add(new Circle(0,20,25));
        shapes.add(face);

        if (args.length >= 1 && args[0].equalsIgnoreCase("image")) {
            String output = args.length >= 2 ? args[1] : "output.jpg";
            int width = 600, height = 400;
            BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics g = img.getGraphics();
            g.setColor(java.awt.Color.WHITE);
            g.fillRect(0, 0, width, height);
            g.setColor(java.awt.Color.BLACK);
            for (GrObject o : shapes) {
                o.draw(g);
            }
            g.dispose();
            ImageIO.write(img, "jpg", new File(output));
            System.out.println("Wrote " + output);
            return;
        }

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Shape Canvas");
            Canvas canvas = new Canvas();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.add(canvas);
            frame.setVisible(true);
            shapes.forEach(canvas::add);
        });
    }
}
