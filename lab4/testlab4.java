import java.util.Iterator;

public class testlab4 {
    public static void main(String[] args) {
        StringBuilder b = new StringBuilder("gtjtgvjg 688 gjghkggh5t 798 ghtr");
        startstrings s1 = new startstrings(b);
        Iterator iterator1 = s1.iterator();
        for (String d1 : s1) {
            System.out.println(d1);
        }
        boolean rty[][] = new boolean[2][2];
        rty[0][0] = true;
        rty[0][1] = false;
        rty[1][0] = true;
        rty[1][1] = false;
        boolmat s2 = new boolmat(2, 2, rty);
        Iterator iterator2 = s2.iterator();
        for (Boolean d : s2) {
            System.out.println(d);
        }
    }
}
