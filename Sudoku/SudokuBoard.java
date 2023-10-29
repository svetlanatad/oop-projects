

import java.util.Random;
public class SudokuBoard {
    private int size;
    private SudokuCell[][] grid;

    public SudokuBoard(int[][] input) {

        this.size = (int) Math.sqrt(input.length);

        this.grid = new SudokuCell[size * size][size * size];

        for (int i = 0; i < size * size; i++) {

            for (int j = 0; j < size * size; j++) {

                boolean val = false;

                if (input[i][j] != 0) {

                    val = true;
                }

                this.grid[i][j] = new SudokuCell(input[i][j], val);

            }
        }
    }


    public SudokuBoard(int size, char difficulty) {
        //creates double array for this object => for this sudoku board of size size and difficulty difficulty
        //but why doesn't it work with this.size = size;
        //
        //        this.grid = new SudokuCell[size * size][size * size]; ? Isn't it still this object => this size and this grid?
        this(new int[size*size][size*size]);

//solves first instead of assigning 0s first then solving
        SudokuSolver.solveSudoku(this);

        int toRemove;
        switch (difficulty) {
            case 'm':
                toRemove = size * size * size * size / 2;
                break;
            case 'h':
                toRemove = 3 * size * size * size * size / 4;
                break;

            case 'e':
                toRemove = size * size * size * size / 4;
                break;
            default:
                toRemove = size * size * size * size / 4;
        }
//hi ヽ(*⌒▽⌒*)ﾉ
        Random rand = new Random();

        for (int i = 0; i < toRemove; i++) {

            int randomNumber1 = rand.nextInt(size * size);

            int randomNumber2 = rand.nextInt(size * size);

            //No need to check if it is fixed, and that statement and getvalue() == 0 aren't if and only if, so one does't imply the other one.
            if (this.grid[randomNumber1][randomNumber2].getValue()== 0) {

                i--;
                continue;
            }

            this.grid[randomNumber1][randomNumber2].setValue(0);
            //no need to setFixed(false) since it's already setting value to be equal to 0

        }

        for(int i=0; i<size*size; i++){
            for(int j=0; j<size*size; j++){

                if (this.grid[i][j].getValue()!= 0) {

                    //we split the statement so that it doesn't miss out on other elements, and whichever isn't 0 it's fixed should be true
                    grid[i][j].setFixed(true);
                }
            }
        }

    }
//Doesn't work

    /*
    public SudokuBoard(int size, char difficulty) {

        this.size = size;


      //  SudokuBoard filledBoard = new SudokuBoard(new int[size * size][size * size]);
        int[][] input = new int[size][size];
        SudokuBoard filledBoard = new SudokuBoard(input);

    //    SudokuBoard filledBoard = new SudokuBoard(size, difficulty);


        for(int qw = 0; qw <size*size; qw++){
            for(int er = 0; er<size*size; er++){
                Random random = new Random();
                filledBoard.grid[qw][er].setValue(random.nextInt(size * size));
                filledBoard.grid[qw][er].setFixed(false);
                if(filledBoard.grid[qw][er].getValue() != 0){
                    filledBoard.grid[qw][er].setFixed(true);
                }
            }
        }

        SudokuSolver.solveSudoku(filledBoard);
        int toRemove;
        if (difficulty == 'e') {
            toRemove = size * size * size * size / 4;
        } else if (difficulty == 'm') {
            toRemove = size * size * size * size / 2;
        } else {
            toRemove = 3 * size * size * size * size / 4;
        }
        for (int z = 0; z < toRemove; z++) {

            Random random = new Random();
            int randomNum1 = random.nextInt(size * size - 1) ;
            int randomNum2 = random.nextInt(size * size - 1) ;

            filledBoard.grid[randomNum1][randomNum2].setValue(0);
            filledBoard.grid[randomNum1][randomNum2].setFixed(false);


        }
        this.grid = filledBoard.grid;
    }

//Doesn't work
*/


    //  SudokuBoard filledSudoku = new SudokuBoard(filledBoard);
//
    //  for(int f = 0; f<size*size; f++){
    //     for(int u = 0; u<size*size; u++){
    //        Random random = new Random();
    //        int randomNumber = random.nextInt(size * size) + 1;
    //         filledBoard[f][u].setValue(randomNumber);
    //         if(!checkIfValueIsOk(f,u)){
    //             if(f == 0){
    //                 f = 0;
    //                u = 0;
    //            }
    //             f--;

    //         }
    //     }
    //     }


    //   SudokuSolver.solveSudoku(filledBoard);




    public int getSize() {

        return size;
    }

    public SudokuCell getCell(int i, int j) {

        return grid[i][j];

    }

    public boolean checkIfValueIsOk(int i, int j) {



        for (int col = 0; col < size * size; col++) {

            if (grid[i][col].getValue() == grid[i][j].getValue() && col != j) {

                return false;
            }

        }
        for (int row = 0; row < size * size; row++) {

            if (grid[row][j].getValue() == grid[i][j].getValue() && row != i) {

                return false;
            }

        }
        for (int row = i / size * size; row < i / size * size + size; row++) {

            for (int col = j / size * size; col < j / size * size + size; col++) {

                if (grid[row][col].getValue() == grid[i][j].getValue() && col != j && row != i) {

                    return false;
                }

            }



        }



        return true;
    }

    public boolean checkIfIsSolved() {

        for (int w = 0; w < size * size; w++) {

            for (int l = 0; l < size * size; l++) {

                if (grid[w][l].getValue() != 0) {

                    if (!checkIfValueIsOk(w, l)) {

                        return false;
                    }
                } else {

                    return false;
                }

            }

        }

        return true;

    }

    public void print() {

        for (int co = 0; co < size * size; co++) {

            if (co % size == 0) {

                for (int k = 0; k < size * size + size + 1; k++) {

                    System.out.print(". ");

                }

                System.out.println();

            }

            System.out.print(". ");

            for (int ol = 0; ol < size * size; ol++) {

                System.out.print(grid[co][ol].getValue() + " ");

                if ((ol + 1) % size == 0) {

                    System.out.print(". ");

                }

            }

            System.out.println();
        }

        for (int k = 0; k < size * size + size + 1; k++) {

            System.out.print(". ");

        }

        System.out.println();
    }

//just for testing

/*
    public static void main(String[] args){
        SudokuBoard board = new SudokuBoard(
                new int[][]{
                        {0, 4, 0, 2},
                        {0, 0, 3, 4},
                        {1, 2, 0, 0},
                        {4, 0, 2, 0}});


        board.print();

        for(int i=0; i<board.getSize()*board.getSize(); i++){
            for(int j=0; j<board.getSize()*board.getSize(); j++){
                System.out.print(board.checkIfValueIsOk(i, j)+" ");
            }
            System.out.println();
        }

        System.out.println(board.checkIfIsSolved());

       // System.out.println("HI");



SudokuSolver.solveSudoku(board);
        board.print();
        for(int i=0; i<board.getSize()*board.getSize(); i++){
            for(int j=0; j<board.getSize()*board.getSize(); j++){
                System.out.print(board.checkIfValueIsOk(i, j)+" ");
            }
            System.out.println();
        }

        System.out.println(board.checkIfIsSolved());




    }

*/

}



