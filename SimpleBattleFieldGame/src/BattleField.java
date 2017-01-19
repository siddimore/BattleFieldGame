/**
 * Created by siddharthmore on 1/18/17.
 */

import java.util.Random;
import java.util.Scanner;

public class BattleField {

    private int[][] board;
    private Scanner scanner;

    public BattleField() {

        board = new int[5][5];
        scanner = new Scanner(System.in);

        for(int i=0; i < board.length; i++)
            for(int j =0; j < board[0].length; j++) {

                // Init all board entries to wave
                board[i][j] = -1;
            }
    }

    // Choose Random location for positioning Ships
    public void initShips() {

        Random rand = new Random();

        for(int i=0; i <3; i++) {

            int k = 0;
            int l = 0;

            // if k and l are same or board[l][k] is already set to 0
            // get k and l again
            do {
                k = rand.nextInt(5);
                l = rand.nextInt(5);
            }
            while(l == k || board[l][k] == 0);

            // set entry to 0 to init ship position on board
            board[l][k] = 0;
        }
    }


    public void printBoard() {

        for(int i=0; i< board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                // Wave
                if (board[i][j] == -1) {
                    System.out.print("~\t");
                }

                // Ship present Here
                if (board[i][j] == 0) {
                    System.out.print("*\t");
                }

                // Ship Hit
                if (board[i][j] == 1) {
                    System.out.print("X\t");
                }

                // Missed Hit
                if (board[i][j] == 2) {
                    System.out.print("|\t");
                }

            }
            System.out.println();
        }
    }

    public void getAndSetShot() {

        System.out.println("\n~ " + "Indicates a wave on the grid");
        System.out.println("* " + "Indicates a Ship before being hit");
        System.out.println("X " + "Indicates a Hit Ship");
        System.out.println("| " + "Indicates Missed Shot");
        System.out.println("Enter number between 0 and 4 for Row and Column for our 5x5 board\n");

        System.out.println("You Get 3 chances to hit all 3 boats\n");
        int count =0;

        while(true) {

            // Check if noof attempts == 3
            if(count == 3)
                break;
            else {

                System.out.println("Enter row hit");
                int i = scanner.nextInt();

                System.out.println("Enter column hit");
                int j = scanner.nextInt();

                ++count;

                // if board[i][j] == 0 which means Ship is present
                // set it to 'X'
                if(board[i][j] == 0) {
                    board[i][j] = 1;
                }
                // set it to missed hit
                else {
                    board[i][j] = 2;
                }

            }
        }
    }

    public static void main(String[] args) {

        // Create instance of Object
        BattleField bF = new BattleField();
        // Init Ships before playing
        bF.initShips();
        // Get input from user and set position on board
        bF.getAndSetShot();
        // print board after playing
        bF.printBoard();
    }
}
