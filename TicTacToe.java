import java.util.Scanner;

public class TicTacToe {

    static char[] board = {
        '1', '2', '3',
        '4', '5', '6',
        '7', '8', '9'
    };

    static void printBoard() {
        System.out.println();
        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("---+---+---");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("---+---+---");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8]);
        System.out.println();
    }

    static boolean checkWinner(char player) {

        int[][] wins = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}
        };

        for (int[] win : wins) {
            if (board[win[0]] == player &&
                board[win[1]] == player &&
                board[win[2]] == player) {
                return true;
            }
        }

        return false;
    }

    static boolean isDraw() {

        for (char position : board) {
            if (position != 'X' && position != 'O') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char currentPlayer = 'X';

        System.out.println("===== TIC TAC TOE =====");

        for (int turn = 1; turn <= 9; turn++) {

            printBoard();

            System.out.print("Player " + currentPlayer + 
                             ", choose position (1-9): ");

            int position = sc.nextInt();

            // Validate position
            if (position < 1 || position > 9) {
                System.out.println("Invalid position! Choose 1-9.");
                turn--;
                continue;
            }

            int index = position - 1;

            // Check occupied position
            if (board[index] == 'X' || board[index] == 'O') {
                System.out.println("Position already occupied!");
                turn--;
                continue;
            }

            // Place player's symbol
            board[index] = currentPlayer;

            // Check winner
            if (checkWinner(currentPlayer)) {
                printBoard();
                System.out.println("🎉 Player " + currentPlayer + " wins!");
                break;
            }

            // Check draw
            if (isDraw()) {
                printBoard();
                System.out.println("Game Draw!");
                break;
            }

            // Switch player
            if (currentPlayer == 'X') {
                currentPlayer = 'O';
            } else {
                currentPlayer = 'X';
            }
        }

        sc.close();
    }
}