import java.util.Arrays;
import java.util.Random;
import java.util.*;

/**
 Owen Shay
 3750150
 CS1083
 Module 2 Assignment
 06/27/2022
 */

public class LotteryTicket {
    private static final int MAX_NUMBER = 50; // even though 49 is the max, the random number generator I coded is exclusive to the top bound, so 50 is pretty much 49 since it cannot be 50
    private static final int MIN_NUMBER = 1;
    public static final int NUMBER_QTY = 6;
    private int[] numbers = {0,0,0,0,0,0};
    private int ticketId;


    public LotteryTicket(int ticketIdIn) {
        chooseRandomNumbers();
        do {
            chooseRandomNumbers();
        }while(duplicateNumber(0));
        ticketId = ticketIdIn;

    }

    public int getTicketId() {

        return ticketId;
    }

    public int[] getNumbers() {

        return numbers;
    }

    public String toString(){

        System.out.println(Main.padLeft(" ",8) + "Tickets" + Main.padLeft(" ",11) + "#Matched" + Main.padLeft(" ",4) + "Prize");
        System.out.println("========================  ========  =========" );
        return ticketId + ":" + Main.padLeft(" ", 2) + numbers[0] + " " + numbers[1] + " " + numbers[2] + " " + numbers[3] + " " + numbers[4] + " " + numbers[5] + Main.padLeft(" ",10);
    }

    private void chooseRandomNumbers() {
        numbers = new int[NUMBER_QTY];  // creates a new array of length 6
        Random num = new Random();

        for(int i = 0; i < NUMBER_QTY; i++){  // loops through the array, placing a random number in each index
            int result = num.nextInt(MAX_NUMBER-MIN_NUMBER) + MIN_NUMBER;  // makes the values in between the two bounds that were set
            numbers[i] = result;

        }
    }

    public boolean duplicateNumber(int i) {

        for(i = 0; i < NUMBER_QTY; i++) {  // O(n^2) time complexity, not ideal, but it's not too bad for looping through only 6^2 elements in the array
            for(int j = i + 1; j < NUMBER_QTY; j++) {
                if(numbers[i] == numbers[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public int countWinningNumbers(int[] winningNumbers) {
        int numbersMatched = 0;

        for(int i = 0; i < NUMBER_QTY; i++) {
            for (int j = 0; j < NUMBER_QTY; j++) {
                if (numbers[i] == winningNumbers[j]) {
                    numbersMatched++;
                }
            }
        }
        return numbersMatched;
    }
}

