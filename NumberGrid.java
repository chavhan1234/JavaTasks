import java.util.Scanner;

 public class NumberGrid {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] grid = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Display the grid
        System.out.println("3x3 Number Grid:");

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }

            System.out.println();
        }

        // Take number from user
        System.out.print("\nEnter number to search: ");
        int number = sc.nextInt();

        boolean found = false;

        // Search number
        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == number) {
                    found = true;
                    break;
                }
            }

            if (found) {
                break;
            }
        }

        if (found) {
            System.out.println(number + " exists in the grid.");
        } else {
            System.out.println(number + " does not exist in the grid.");
        }

        sc.close();
    }
}