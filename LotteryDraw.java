import java.util.ArrayList;
import java.util.Arrays;

public class LotteryDraw {

        private int ticketQty = 0;
        private LotteryTicket[] tickets = {};
        private LotteryTicket winningNumbers = new LotteryTicket(1000);
        private static final double[] prizeAmount = {0.0, 0.0, 10.0, 100.0, 1_000.0, 100_000.0, 1_000_000.0};

        public LotteryDraw(int maxTickets) {
            System.out.println("Winning Numbers: " + getWinningNumbers()[0] + " " + getWinningNumbers()[1] + " " + getWinningNumbers()[2] + " " + getWinningNumbers()[3] + " " + getWinningNumbers()[4] + " " + getWinningNumbers()[5]);
            ticketQty = maxTickets;
            for(int i = 0; i <= maxTickets;i++) {
                LotteryTicket ticket = new LotteryTicket(1000 + i);
                addTicket(ticket);
            }
        }

        public LotteryTicket getTicket(int index) {

            return tickets[index];
        }

        public boolean addTicket(LotteryTicket t) {
             for(int i = 1; i < ticketQty; i++){
                 tickets[i] = t;
                 return true;
             }
            return false;
        }

        public double getPrizeAmount(int n) {
            return prizeAmount[n];
        }

        public int[] getWinningNumbers() {
            return winningNumbers.getNumbers();
        }
    }

