

public class Nonogram implements Comparable<Nonogram>  {

    //• String name representing the name of the puzzle.
    private String name;
    //• boolean two-dimensional array board representing the cells of the puzzle. A value of true
    //indicates that a cell is painted.
    boolean[][] board;

    //• boolean two-dimensional array solution representing the solution configuration for this puz- zle.
    private boolean solution[][];


    //• integer two-dimensional ragged array rowRules representing all of the row rules.
    private int rowRules[][];

    //• integer two-dimensional ragged array columnRules representing all of the column rules.
    private int columnRules[][];

    //• width() - Returns the width of the board.
    public int width(){
        return board[0].length;
    }
    //• height() - Returns the height of the board.
    public int height(){
        return board.length;
    }
    //• columnRuleMaxSize() - Returns the maximum length of any rule in the columnRules array (i.e., the maximum number of blocks in any column).
    public int columnRuleMaxSize() {
        int maxSize = 0;
        for (int[] column : columnRules) {
            maxSize = Math.max(maxSize, column.length);
        }
        return maxSize;
    }
    //• public int rowRuleMaxSize() - Returns the maximum length of any rule in the rowRules array.
    public int rowRuleMaxSize(){
        int maxSize = 0;
        for (int[] row : rowRules) {
            maxSize = Math.max(maxSize, row.length);
        }
        return maxSize;

    }
    //• getCell(int row, int column) - Returns the value of the cell at the given row and column.
    public boolean getCell(int row, int column) {
        return board[row][column];
    }
    //• getRowRule(int i) - Returns the rule at the given index i in the rowRules array.
    public int[] getRowRule(int i) {
        return rowRules[i];
    }

    //• getColumnRule(int i) - Returns the rule at the given index i in the columnRules array.
    public int[] getColumnRule(int i) {
        return columnRules[i];
    }
    //• flip(int row, int col) - Flips (colors or clears) the value of the cell at the given row and column.
    public void flip(int row, int col) {
        board[row][col] = !board[row][col];
    }
    //• setCells(boolean[][] arr) - Sets the cells in the board array to the values in the given 2D boolean array.
    public void setCells(boolean[][] arr) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = arr[i][j];
            }
        }
    }
    //• clear() - Clears the board. Can use setCells(...)
    public void clear() {

        boolean[][] emptyBoard = new boolean[this.width()][this.height()];
        for(int i = 0; i < this.width(); i++){
            for(int j = 0; j < this.height(); j++){
                emptyBoard[i][j] = false;
            }
        }
        setCells(emptyBoard);

        }
        //• fillWithSolution() - Sets the cells in the board to the values in the solution.
    public void fillWithSolution() {
        setCells(solution);
    }

    //• toString() - Returns the name of the Nonogram object.
    public String toString() {
        return this.name;
    }
    //• compareTo(Nonogram nonogram) - Returns the difference between the sum of the width and height of this object and the sum of the width and height of the given object.
    public int compareTo(Nonogram nonogram) {
        int sumOfWidthAndHeight = this.width() + this.height();
        int otherSumOfWidthAndHeight = nonogram.width() + nonogram.height();
        return sumOfWidthAndHeight - otherSumOfWidthAndHeight;
    }

    //Acknowledged chatgpt collaboration with the checkIfSolved() method implementation
    //• checkIfSolved() - This method checks if the current state of the board satisfies the row and column rules. If all rules are satisfied, the method returns true, otherwise it returns false.
    public boolean checkIfSolved() {
        // Check if all rows satisfy their respective rules
        for (int i = 0; i < this.width(); i++) {
            int[] row = getRowRule(i);
            int[] rule = rowRules[i];
            if (!checkRule(row, rule)) {
                return false;
            }
        }

        // Check if all columns satisfy their respective rules
        for (int j = 0; j < height(); j++) {
            int[] column = getColumnRule(j);
            int[] rule = columnRules[j];
            if (!checkRule(column, rule)) {
                return false;
            }
        }

        // If all rules are satisfied, return true
        return true;
    }
    private boolean checkRule(int[] cells, int[] rule) {
        int i = 0;
        for (int r : rule) {
            if (r == 0) {
                i++;
                continue;
            }
            int count = 0;
            while (i < cells.length && cells[i] == 1) {
                count++;
                i++;
            }
            if (count != r) {
                return false;
            }
            i++;
        }
        while (i < cells.length && cells[i] == 1) {
            return false;
        }
        return true;
    }


//• Nonogram(String configuration): Constructor that takes a string representation of the nonogram and
// initializes its attributes. The format of the argument string is described below (additionally refer to the file “example.txt”):
    public Nonogram(String configuration) {

        String[] lines = configuration.split("\n");

        // Parse puzzle name, number of columns, and number of rows
        name = lines[0];
        int numCols = Integer.parseInt(lines[1]);
        int numRows = Integer.parseInt(lines[2]);

        // Parse row and column rules
        rowRules = new int[numRows][];
        columnRules = new int[numCols][];
        int lineNum = 4; // Starting line number for row rules

        for (int i = 0; i < numRows; i++) {
            String[] ruleStrings;
            if (lines[lineNum].isEmpty()) { // Skip empty lines
                lineNum++;
            }
            if (lines[lineNum].contains(",")) {
                ruleStrings = lines[lineNum++].split(",");
                int[] rules = new int[ruleStrings.length];
                for (int j = 0; j < ruleStrings.length; j++) {
                    rules[j] = Integer.parseInt(ruleStrings[j]);
                }
                rowRules[i] = rules;
            } else {
                ruleStrings = lines[lineNum++].split("");
                int[] rules = new int[ruleStrings.length];
                for (int j = 0; j < ruleStrings.length; j++) {
                    rules[j] = Integer.parseInt(ruleStrings[j]);
                }
                rowRules[i] = rules;
            }


        }

        for (int i = 0; i < numCols; i++) {
            String[] ruleStrings;
            if (lines[lineNum].isEmpty()) { // Skip empty lines
                lineNum++;
            }
            if (lines[lineNum].contains(",")) {
                ruleStrings = lines[lineNum++].split(",");
                int[] rules = new int[ruleStrings.length];
                for (int j = 0; j < ruleStrings.length; j++) {
                    rules[j] = Integer.parseInt(ruleStrings[j]);
                }
                columnRules[i] = rules;
            } else {
                ruleStrings = lines[lineNum++].split("");
                int[] rules = new int[ruleStrings.length];
                for (int j = 0; j < ruleStrings.length; j++) {
                    rules[j] = Integer.parseInt(ruleStrings[j]);
                }
                columnRules[i] = rules;
            }


        }
        boolean[][] board = new boolean[numRows][numCols];
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < numCols; j++){
                board[i][j] = false;

            }
        }
        this.board = board;

        // Parse solution
        solution = new boolean[numRows][numCols];
        if (lines[lineNum].isEmpty()) { // Skip empty lines
            lineNum++;
        }
        String solutionStr = lines[lineNum];
        String[] solutionChunks = solutionStr.split("(?<=\\G.{" + numCols + "})"); // split into chunks of numCols characters
        for (int i = 0; i < numRows; i++) {
            String rowStr = solutionChunks[i];
            for (int j = 0; j < numCols; j++) {
                solution[i][j] = rowStr.substring(j, j + 1).equals("1");
            }
        }
        this.solution = solution;
    }
    public boolean[][] getSolution() {
        return solution;
    }
}

