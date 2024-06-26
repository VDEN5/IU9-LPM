import java.util.ArrayList;
public class startstrings implements Iterable<String> {
    private int n;
    ArrayList<String> res;
    private String str;
    private StringBuilder sb;
    private void parseb() {
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ') {
                if (str.length() != 0) {
                    res.add(str);
                    n++;
                }
                str = "";
            } else {
                if (sb.charAt(i) <= '9' && sb.charAt(i) >= '0') {
                    str += sb.charAt(i);
                } else
                    str = "";
            }
        }
        if (str.length() != 0) {
            res.add(str);
            n++;
        }
    }
    public startstrings(StringBuilder x1) {
        this.sb = x1;
        res = new ArrayList<>();
        this.str = "";
        parseb();
    }
    public graphIterator iterator() {
        return new graphIterator();
    }
    private class graphIterator implements java.util.Iterator<String> {
        int index = 0;
        public boolean hasNext() {
            return index < n;
        }
        public String next() {
            return res.get(index++);
        }
    }
}