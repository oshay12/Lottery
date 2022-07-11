public class test {
    public static void main(String[] args) {
        LotteryDraw draw = new LotteryDraw(10);
    }

    public static String padLeft(String s, int width)
    { 	String r = s;
        while (r.length() < width)
            r = " " + r;
        return r;
    }
}
