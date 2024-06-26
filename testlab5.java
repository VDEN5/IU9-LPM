import java.util.*;
import java.util.stream.Stream;
import javax.swing.text.html.Option;
class quadro {
    int x1, y1, x2, y2, x3, y3, x4, y4;
    String name;
    quadro(String name, int x1, int y1, int x2, int y2, int x3, int y3, int x4,
           int y4) {
        this.name = name;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.x3 = x3;
        this.y2 = y2;
        this.y3 = y3;
        this.x4 = x4;
        this.y4 = y4;
    }
    public double getarea() {
        return 0.5
                * Math.abs(x1 * y2 + x2 * y3 + x3 * y4 + x4 * y1 - y1 * x2 - y2 * x3
                - y3 * x4 - y4 * x1);
    }
    public double getdiag() {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2))
                + Math.sqrt((x3 - x4) * (x3 - x4) + (y3 - y4) * (y3 - y4));
    }
}
class float01 {
    int a;
    int b;
    float01(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public double getfl() {
        return a / b;
    }
}
class ft {
    HashMap<Integer, float01> Table;
    double total;
    ft() {
        Table = new HashMap<>();
        total = -1;
    }
    void add(int a, int b) {
        if (a / b > total)
            total = a / b;
        if ((a > 0) && (b > 0))
            Table.put(1, new float01(a, b));
        if ((a < 0) && (b > 0))
            Table.put(2, new float01(a, b));
        if ((a < 0) && (b < 0))
            Table.put(3, new float01(a, b));
        if ((a > 0) && (b < 0))
            Table.put(4, new float01(a, b));
    }
    public Stream<Double> nameStream() {
        ArrayList<Double> result = new ArrayList<>();
        Table.entrySet().stream().forEach(x -> result.add(x.getValue().getfl()));
        return result.stream();
    }
    public Optional<float01> getProduct() {
        Optional<float01> result = Optional.empty();
        Optional<Map.Entry<Integer, float01>> tmp =
                Table.entrySet()
                        .stream()
                        .filter(x -> x.getValue().getfl() >= total)
                        .findFirst();
        if (tmp.isPresent())
            result = Optional.ofNullable(tmp.get().getValue());
        return result;
    }
}
class gt {
    HashMap<String, quadro> Table;
    int total[];
    double m;
    gt() {
        Table = new HashMap<>();
        total = new int[10];
        for (int i = 0; i < 10; i++) {
            total[i] = 0;
        }
        m = 0;
    }
    void add(String str, int x1, int y1, int x2, int y2, int x3, int y3, int x4,
             int y4) {
        quadro q = new quadro(str, x1, y1, x2, y2, x3, y3, x4, y4);
        if (m > q.getdiag())
            m = q.getdiag();
        Table.put(str, q);
        int s = (int) q.getarea();
        s = (int) s / 10;
        total[s]++;
    }
    public Stream<Double> nameStream() {
        ArrayList<Double> result = new ArrayList<>();
        Table.entrySet().stream().forEach(x -> result.add(x.getValue().getarea()));
        return result.stream();
    }
    public Optional<quadro> getProduct() {
        Optional<quadro> result = Optional.empty();
        Optional<Map.Entry<String, quadro>> tmp =
                Table.entrySet()
                        .stream()
                        .filter(x -> x.getValue().getdiag() >= m)
                        .findFirst();
        if (tmp.isPresent())
            result = Optional.ofNullable(tmp.get().getValue());
        return result;
    }
}
public class testlab5 {
    public static void main(String[] args) {
        ft t1 = new ft();
        t1.add(1, 1);
        t1.add(-4, 2);
        t1.nameStream().forEach(System.out::println);
        System.out.println(t1.getProduct().get().getfl());
        gt t2 = new gt();
        t2.add("b", 0, 0, 4, 0, 2, 4, 0, 5);
        t2.add("a", 1, 1, 2, 1, 5, 4, 2, 4);
        t2.nameStream().forEach(System.out::println);
        System.out.println(t2.getProduct().get().getdiag());
    }
}