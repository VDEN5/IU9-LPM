public class sentences implements Comparable<sentences> {
    private String s;
    public sentences(String s) {
        this.s = s;
    }
    public int countmaxlenword() {
        String str = this.s;
        int k = 0, ma = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                if (k >= ma)
                    ma = k;
                k = 0;
            }
            if (((str.charAt(i) > 'a') && (str.charAt(i) < 'z'))
                    || ((str.charAt(i) > 'A') && (str.charAt(i) < 'Z')))
                k++;
        }
        if (k >= ma)
            ma = k;
        return ma;
    }
    public int compareTo(sentences obj) {
        return this.countmaxlenword() - obj.countmaxlenword();
    }
}