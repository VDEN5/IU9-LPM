import static java.lang.Math.*;
public class Universe {
    private static int n;
    private String name;
    private Star[] stars;
    public Universe(String name, Star[] allstars) {
        this.name = name;
        this.stars = allstars;
        this.n = allstars.length;
    }
    public double volume() {
        int sumx = 0, sumy = 0, sumz = 0, f = this.n;
        for (int i = 0; i < f; i++) {
            sumx += this.stars[i].getX();
            sumy += this.stars[i].getY();
            sumz += this.stars[i].getZ();
        }
        double x1 = sumx / f;
        double y1 = sumy / f;
        double z1 = sumz / f;
        double x2 = x1 - this.stars[0].getX();
        double y2 = y1 - this.stars[0].getY();
        double z2 = z1 - this.stars[0].getZ();
        double r = pow(x2 * x2 + y2 * y2 + z2 * z2, 0.5);
        return 3.14 * (4 / 3) * r * r * r;
    }
}
