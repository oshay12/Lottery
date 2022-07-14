import java.text.NumberFormat;
/**
 * @author Owen Shay 3750150
 CS1083
 Module 2 Assignment
 06/27/2022
 */

public class LotteryDraw {

    private int ticketQty;
    private LotteryTicket[] tickets; //An array of LotteryTicket objects
    private LotteryTicket winningNumbers = new LotteryTicket(0); //A single LotteryTicket representing the winning numbers for this draw
    private static final double[] prizeAmount = {0.0, 0.0, 10.0, 100.0, 1_000.0, 100_000.0, 1_000_000.0}; //Indicates the $ prize amount for each possible number of winning numbers (0 to 6) that a LotteryTicket can match

    /**
     * public LotteryDraw(int maxTickets)
     Constructs a lottery draw given the maximum quantity of tickets for this draw

     * @param maxTickets - The maximum quantity of tickets for this draw
     */
    public LotteryDraw(int maxTickets) {
        ticketQty = maxTickets;
        tickets = new LotteryTicket[ticketQty];
        System.out.println("Winning Numbers:" + test.padLeft(String.valueOf(getWinningNumbers()[0]),3) + test.padLeft(String.valueOf(getWinningNumbers()[1]),3) + test.padLeft(String.valueOf(getWinningNumbers()[2]),3) + test.padLeft(String.valueOf(getWinningNumbers()[3]),3) + test.padLeft(String.valueOf(getWinningNumbers()[4]),3) + test.padLeft(String.valueOf(getWinningNumbers()[5]),3));
        System.out.println(test.padLeft(" ",8) + "Tickets" + test.padLeft(" ",11) + "#Matched" + test.padLeft(" ",4) + "Prize");
        System.out.println("========================  ========  =========" );

        for(int i = 0; i < ticketQty;i++) { //creates new tickets and adds them to the ticket array until we reach the desired ticket quantity
            LotteryTicket ticket = new LotteryTicket(1001 + i);
            addTicket(ticket);
        }

        for(int i = 0; i < ticketQty;i++) { //prints formatted ticket, numbers matched and prize amount for the ticket in $
            LotteryTicket ticket = getTicket(i);
            double prizeAmount = getPrizeAmount(ticket.countWinningNumbers(getWinningNumbers())); //gets the prize amount for the current ticket and stores it to be formatted
            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            String formattedPrizeAmount = formatter.format(prizeAmount); //formats the prize amount into a currency
            System.out.println(ticket + test.padLeft(String.valueOf(ticket.countWinningNumbers(getWinningNumbers())), 8) + test.padLeft(formattedPrizeAmount,12));
        }
    }

    /**
     * public LotteryTicket getTicket(int index)
     Accessor method for a single LotteryTicket

     * @param index - The index from which to retrieve a LotteryTicket
     * @return A reference to the LotteryTicket in position 'index' (or null in the case of an invalid index)
     */
    public LotteryTicket getTicket(int index) {return tickets[index];}

    /**
     * public boolean addTicket(LotteryTicket t)
     Adds a LotteryTicket to this draw

     * @param t - The LotteryTicket to be added
     * @return false if the draw is full and cannot accept any more tickets, true otherwise
     */
    public boolean addTicket(LotteryTicket t) {
        for (int i = 0; i < ticketQty; i++) {
            if (tickets[i] == null) {
                tickets[i] = t;
                return true;
            }
        }
        return false;
    }

    /**
     * public double getPrizeAmount(int n)
     Returns the prize amount won for any ticket with a given quantity of numbers that match the winning
     numbers

     * @param n - The quantity of matching numbers
     * @return The prize amount in dollars (0.0 in the case of an invalid value for n)
     */
    public double getPrizeAmount(int n) {return prizeAmount[n];}

    /**
     * public int[] getWinningNumbers()
     Returns the winning numbers for this draw in unsorted order

     * @return The winning numbers for this draw in unsorted order
     */
    public int[] getWinningNumbers() {return winningNumbers.getNumbers();}
}
