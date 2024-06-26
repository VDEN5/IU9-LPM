public class Testuniverse {
    public static void main(String[] args) {
        Star sta1 = new Star("bjkg", 33, 44, 55);
        Star sta2 = new Star("kjcerkv", 9, 4, 2);
        Star sta3 = new Star("bjkefbv", 1056, 2024, 1234);
        Star sta[] = {sta1, sta2, sta3};
        Universe uni = new Universe("ndkj3r2rbnk", sta);
        System.out.println(uni.volume());
    }
}
