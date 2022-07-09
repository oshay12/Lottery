public class Main {
    public static void main(String[] args) {
        LotteryTicket lotto = new LotteryTicket(1001);
        LotteryDraw draw = new LotteryDraw(10);
        System.out.println(lotto);

    }

    public static String padLeft(String s, int width)
    { 	String r = s;
        while (r.length() < width)
            r = " " + r;
        return r;
    }
}