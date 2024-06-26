import static java.lang.Math.sqrt;

import java.awt.*;
import javax.swing.*;
public class CanvasPanel extends JPanel {
    private int radius = 100;
    int vertices = 3;
    public void setRadius(int r) {
        radius = r;
        repaint();
    }
    public void setnums(int n) {
        vertices = n;
        repaint();
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        double step = 2 * Math.PI / vertices;
        int[] x = new int[vertices];
        int[] y = new int[vertices];
        int width = radius;
        int height = radius;
        int rx = 0;
        int ry = 0;
        double angleOffset = 3;
        int xrad = width / 2;
        int yrad = height / 2;
        for (int i = 0; i < vertices; i++) {
            x[i] = rx + xrad + (int) (Math.cos(angleOffset + i * step) * xrad);
            y[i] = ry + yrad + (int) (Math.sin(angleOffset + i * step) * yrad);
        }
        g.drawPolygon(x, y, vertices);
        int[] x1 = new int[vertices];
        int[] y1 = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            x1[i] = x[i];
            int tyu = (int) sqrt(
                    (x[0] - x[1]) * (x[0] - x[1]) + (y[0] - y[1]) * (y[0] - y[1]));
            y1[i] = y[i] + tyu;
        }
        for (int i = 0; i < vertices; i++) {
            g.drawLine(x[i], y[i], x1[i], y1[i]);
        }
        g.drawPolygon(x1, y1, vertices);
    }
}