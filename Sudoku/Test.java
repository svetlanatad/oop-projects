
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Hi, welcome to the program! (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ ");

        System.out.println();

        System.out.print("Choose size for the sudoku board (2, 3, or 4): ");

        int size = scanner.nextInt();

        System.out.print("Choose difficulty level (e, m, or h): ");

        char difficulty = scanner.next().charAt(0);

        scanner.close();

        SudokuBoard board = new SudokuBoard(size, difficulty);

        System.out.println("Original Puzzle:");

        board.print();

        scanner.close();

        long startTime = System.nanoTime();

        SudokuSolver.solveSudoku(board);

        System.out.println("Solved Puzzle:");

        board.print();

        long endTime = System.nanoTime();

        //long type - long type / double value should be value and should output more precise result

        double duration = (endTime - startTime) / 1000000.0;

        System.out.println("Time taken: " + duration + " milliseconds");

    }

}
