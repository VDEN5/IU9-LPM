public class lines implements Comparable<lines> {
    private int n;
    private int[] x;
    private int[] y;
    public lines(int n, int[] x, int[] y) {
        this.n = n;
        this.x = x;
        this.y = y;
    }
    public int countper() {
        int k = 0;
        for (int i = 0; i < this.n - 1; i++) {
            int x1 = this.x[i], x2 = this.x[i + 1], y1 = this.y[i],
                    y2 = this.y[i + 1];
            if (((y1 * y2 < 0) || (x1 * x2 < 0)) && ((y1 / x1) == (y2 / x2))) {
                k++;
                continue;
            }
            if ((x1 > 0) && (y1 > 0) && (x2 * y2 < 0))
                k++;
            if ((x1 > 0) && (y1 > 0) && (x2 < 0) && (y2 < 0))
                k += 2;
            if ((x1 > 0) && (y1 < 0) && (x2 * y2 > 0))
                k++;
            if ((x1 > 0) && (y1 < 0) && (x2 < 0) && (y2 > 0))
                k += 2;
            if ((x1 < 0) && (y1 < 0) && (x2 * y2 < 0))
                k++;
            if ((x1 < 0) && (y1 < 0) && (x2 > 0) && (y2 > 0))
                k += 2;
            if ((x1 < 0) && (y1 > 0) && (x2 * y2 > 0))
                k++;
            if ((x1 < 0) && (y1 > 0) && (x2 > 0) && (y2 < 0))
                k += 2;
        }
        return k;
    }
    public int compareTo(lines obj) {
        return this.countper() - obj.countper();
    }
}
