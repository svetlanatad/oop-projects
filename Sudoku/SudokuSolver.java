

import java.util.Random;


public class SudokuSolver {

    private static Random random = new Random();

    public static void solveSudoku(SudokuBoard board) {
        solveSudoku(board, 0, 0);
    }

    public static boolean solveSudoku(SudokuBoard board, int i, int j) {

        int size = board.getSize();
//if currently at the very last cell <=> i == size*size - 1 && j == size*size - 1 as indexes
        if (i == size * size-1 && j== size*size-1) {
            for(int n = 1; n<=size*size; n++){
                //Since the HW algorithm didn't indicate if I should use random number generator here as well, I will use this simple approach.
                SudokuCell cell = board.getCell(i, j);

                cell.setValue(n);

                if(board.checkIfValueIsOk(i,j)){

                    return true;


                }

            }


        }
        //the boolean usedValues contain size*size elements, => they're of size*size
        boolean[] usedValues = new boolean[size * size];

        SudokuCell cell = board.getCell(i, j);

        if(!cell.getFixed()) {
//no need for an infinite true loop
            //counting val from 1 to size*size and not from 0 to size*size - 1 so that it doesn't throw out of bounds exception as it was mentioned in the hw
            for (int val = 1; val <= size * size; val++) {
                //initializing random number inside the for loop, we +1 because random takes size*size exclusive



                int randomNumber = random.nextInt(size * size) + 1;
                //keep reassigning if its already been considered
                while (usedValues[randomNumber-1]){
                    randomNumber = random.nextInt(size * size) + 1;
                }
                //we -1 to get the correct randomNumber index
                //if it got out of the loop then we finally found one that hasn't been considered yet, and we mark it as true since we use it to set value of the cell
                usedValues[randomNumber-1] = true;
                cell.setValue(randomNumber);

                //proceeding with the algorithm

                if (board.checkIfValueIsOk(i, j)) {

                    int next_i = i;
                    int next_j = j + 1;

                    if (next_j == size * size ) {

                        next_j = 0;
                        next_i++;
                    }

                    if (solveSudoku(board, next_i, next_j)) {
                        // Check if the entire board is valid before returning true
                        for (int row = 0; row < size * size; row++) {
                            for (int col = 0; col < size * size; col++) {
                                if (!board.checkIfValueIsOk(row, col)) {

                                    return false;
                                }
                            }
                        }
                        return true;
                    }
                }
            }


            cell.setValue(0);
            return false;

        } else {

            int next_i = i;
            int next_j = j + 1;

            if (next_j == size * size) {

                next_j = 0;
                next_i++;
            }


//return solveSudoku(board, i, j + 1) || solveSudoku(board, i + 1, j); is infinitely recursing because of the or, infinite loop results

            //no need to check the condition  if (cell.getValue() != 0)
            //＼(＾▽＾)／
            //                return solveSudoku(board, next_i, next_j) already returns the returned value

    return solveSudoku(board, next_i, next_j);


        }
    }
}




//THIS WORKS!!!!!!!!!!!!!!
// FROM HERE
/*
public class SudokuSolver {

    private static Random random = new Random();

    public static void solveSudoku(SudokuBoard board) {
        solveSudoku(board, 0, 0);
    }

    public static boolean solveSudoku(SudokuBoard board, int i, int j) {
        int size = board.getSize();

        if (i == size * size) {
            return true;
        }

        SudokuCell cell = board.getCell(i, j);

        if (!cell.getFixed()) {
            for (int val = 1; val <= size * size; val++) {
                cell.setValue(val);

                if (board.checkIfValueIsOk(i, j)) {
                    int next_i = i;
                    int next_j = j + 1;

                    if (next_j == size * size) {
                        next_j = 0;
                        next_i++;
                    }

                    if (solveSudoku(board, next_i, next_j)) {
                        return true;
                    }
                }
            }

            cell.setValue(0);
            return false;
        } else {
            int next_i = i;
            int next_j = j + 1;

            if (next_j == size * size) {
                next_j = 0;
                next_i++;
            }

            if (cell.getValue() != 0) {
                return solveSudoku(board, next_i, next_j);
            } else {
                return solveSudoku(board, i, j + 1) || solveSudoku(board, i + 1, j);
            }
        }
    }
}
*/

//TO HERE




















/*


import java.util.Random;


public class SudokuSolver {

    private static Random random = new Random();

    public static void solveSudoku(SudokuBoard board) {
        solveSudoku(board, 0, 0);
    }

    public static boolean solveSudoku(SudokuBoard board, int i, int j) {
        int size = board.getSize();

        if (i == size * size) {
            return true;
        }

        SudokuCell cell = board.getCell(i, j);

        if (!cell.getFixed()) {
//for loop to assign val to cell

            boolean[] usedValues = new boolean[size*size];
            for (int ik = 1; ik < size*size; ik++) {
                int rand = (int) (Math.random() * (size * size));
                if (!usedValues[rand]) {
                    usedValues[rand] = true;
                    cell.setValue(rand);

                    if (board.checkIfValueIsOk(i, j)) {
                        int ij = i;
                        int ji = j + 1;

                        if (ji == size * size) {
                            ji = 0;
                            ij++;
                        }

                        if (solveSudoku(board, ij, ji)) {
                            return true;
                        }
                    }
                } else {


                    ik--;
                }

            }

   //         }

            cell.setValue(0);
            return false;
        } else {
            int ij = i;
            int ji = j + 1;

            if (ji == size * size) {
                ji = 0;
                ij++;
            }

            if (cell.getValue() != 0) {
                return solveSudoku(board, ij, ji);
            } else {
                return solveSudoku(board, i, j + 1) || solveSudoku(board, i + 1, j);
            }
        }
    }
}

*/




/*
import java.util.Random;


public class SudokuSolver {

    private static Random random = new Random();

    public static void solveSudoku(SudokuBoard board) {
        solveSudoku(board, 0, 0);
    }

    public static boolean solveSudoku(SudokuBoard board, int i, int j) {
        int size = board.getSize();
        SudokuCell cell = board.getCell(i, j);

        if (!cell.getFixed()) {
            for (int ij = 0; ij < size * size; ij++) {

                int randomNumber = random.nextInt(size * size + 1);
                cell.setValue(randomNumber);

                if (board.checkIfValueIsOk(i, j)) {
                    if (i == size * size - 1 && j == size * size - 1) {
                        return true;
                    } else {
                        i++;
                        if (i == size * size - 1) {
                            j = 0;
                            if (solveSudoku(board, i, j)) {
                                return true;
                            }
                        }

                    }
                }
                cell.setValue(0);
                return false;


            }
        } else {
            if (i == size * size - 1 && j == size * size - 1) {
                return true;

            } else {

                if(board.checkIfValueIsOk(i,j)){
                    i = 0;
                    return solveSudoku(board, i, j + 1);

                }


            }
            if(board.checkIfValueIsOk(i,j)){
                j = 0;
                return solveSudoku(board, i + 1, j);

            }

        }
    return solveSudoku(board, i,j);
    }
}
*/
 /*   public static boolean solveSudoku(SudokuBoard board, int i, int j) {
        int size = board.getSize();

        if (j >= size) {
            i++;
            j = 0;
        }

        if (i >= size) {
            return true;
        }

        SudokuCell cell = board.getCell(i, j);
        if (cell.getFixed()) {

            return solveSudoku(board, i, j + 1);
        }


        int[] values = new int[size];
        for (int k = 0; k < size; k++) {
            values[k] = k + 1;
        }


        for (int k = size - 1; k > 0; k--) {
            int index = random.nextInt(k + 1);
            int temp = values[k];
            values[k] = values[index];
            values[index] = temp;
        }

        for (int value : values) {
            cell.setValue(value);

            if (board.checkIfValueIsOk(i, j)) {
                if (solveSudoku(board, i, j + 1)) {
                    return true;
                }
            }
        }

        cell.setValue(0);
        return false;


  */



