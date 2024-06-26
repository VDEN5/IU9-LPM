import java.util.Arrays;
public class testlab3 {
    public static void main(String[] args) {
        // 1 number
        int[] x11 = {1, -5, 2};
        int[] y11 = {1, -3, -1};
        int[] x22 = {2, 3, 4};
        int[] y22 = {2, -3, 4};
        lines li1 = new lines(3, x11, y11);
        lines li2 = new lines(3, x22, y22);
        lines[] li = new lines[] {li1, li2};
        for (lines l : li) {
            System.out.println(l.countper());
        }
        Arrays.sort(li);
        for (lines l : li) {
            System.out.println(l.countper());
        }
        // 2 number
        String str1 = "rcger jherbc";
        String str2 = "I love Anna";
        String str3 = "Hello world!";
        sentences[] s = new sentences[] {
                new sentences(str1), new sentences(str2), new sentences(str3)};
        for (sentences s1 : s) {
            System.out.println(s1.countmaxlenword());
        }
        Arrays.sort(s);
        for (sentences s1 : s) {
            System.out.println(s1.countmaxlenword());
        }
    }
}