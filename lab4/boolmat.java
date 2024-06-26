import java.util.ArrayList;
public class boolmat implements Iterable<Boolean> {
    private int m;
    private int n;
    private boolean mat[][];
    ArrayList<Boolean> res;
    private boolean scanstr(int f) {
        boolean res1 = false;
        for (int i = 0; i < n; i++) {
            res1 = res1 || this.mat[f][i];
        }
        return res1;
    }
    public boolmat(int m, int n, boolean mat[][]) {
        this.m = m;
        this.n = n;
        this.mat = mat;
    }
    public graphIterator1 iterator() {
        return new graphIterator1();
    }
    private class graphIterator1 implements java.util.Iterator<Boolean> {
        int index = 0;
        public boolean hasNext() {
            return index < m;
        }
        public Boolean next() {
            return scanstr(index++);
        }
    }
}