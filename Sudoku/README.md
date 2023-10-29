**Term/Year:** Fall 2022

**Subject Code and Course Number**: CS120 Intro to OOP, Sections B & D

**University and Faculty:** American University of Armenia, CSE

**Instructor name**  Monika Stepanyan

**Sudoku and Sudoku Solver**: The goal is to make Sudoku with a Sudoku solver :)


**Description** This code is a simple implementation of the Sudoku Game and a solver for it.
Sudoku is a logic-based number-placement puzzle. The objective is to completely fill an n × n (initially only partially filled) grid that is divided into n subgrids (also called “boxes”, “blocks”, or “regions”) of size √n × √n.
The rules state that each column, each row, and each of the subgrids should contain all of the digits from 1 to n.

**Sudoku Cell** The class SudokuCell that represents a single cell in a Sudoku puzzle. It has two attributes: value and fixed. The value represents the current value of the cell, which can be any integer between 0 and n. The fixed property is a boolean value that indicates whether the cell’s value is fixed or not (i.e., whether it was initially provided or was empty).
The class includes
• a single constructor that takes in two values
• methods for accessing and mutating the instance variables


**SudokuBoard** The class SudokuBoard  represents a Sudoku puzzle board. It has two main properties: size and grid. The size property represents the size of a subgrid (√n). The grid is a two-dimensional array of SudokuCell objects, representing each cell in the puzzle.
The class also includes the following methods;
• SudokuBoard(...): takes as an argument a two-dimensional array of integers representing the initial state of the puzzle, and initializes the attributes based on it. Empty cells are indicated by 0s.
• getSize(): returns the size of the puzzle
• getCell(int i, int j): returns the SudokuCell at position (i, j) in the grid
• checkIfValueIsOk(int i, int j): checks whether the value of a cell at position (i, j) is valid according to the rules of Sudoku.
• checkIfIsSolved(): checks if the current state of the puzzle board is a valid solution. The state represents a solution if there are no empty cells and no value violates the rules of Sudoku.
• print(): prints the current state of the puzzle board. Empty cells should be represented by zeros. Also prints the borders and the lines that divide the grid into subgrids. Make sure that all cells are of the same width (take up equal number of spaces).


**SudokuSolver** The class SudokuSolver is going to be responsible for solving SudokuBoards.
The class contains two static methods:
• public void solveSudoku(SudokuBoard): solves the puzzle starting from cell (0, 0).
• ??? boolean solveSudoku(SudokuBoard, int i, int j): solves the puzzle recursively, and returns true when solution is found (false if no solution exists). For more details, read below.
The second method uses a recursive backtracking algorithm to iterate through each cell of the puzzle grid in row-major order (from left to right, from top to bottom) and check if a given value is valid according to the rules of Sudoku. Refer to the code for how backtracking algorithm was implemented.

**Continuing description** Currently the only constructor of SudokuBoard accepts a two dimensional array of integers (which should be manually copy pasted into the program).
To make the testing process easier, I added another constructor that generates problem in- stances from scratch.
A common scheme for generating Sudoku problem instances is the following:
• Randomly generate a fully filled board where no value violates the rules.
• Remove some cells from it. Different number of cells may be removed depending on the desired complexity.
Luckily for us, we already have a method capable of performing the first step. 2
Add an overloaded constructor to the SudokuBoard class. This constructor should
• Take the size and the difficulty level (represented by characters ‘e’– easy, ‘m’– medium, ‘h’–
hard) as input.
• Call the other constructor and initialize the instance variable with an empty board of an appropriate size
• Solve the board using backtracking (this will result in a random full Sudoku being generated).
• Depending on the difficulty level, find out the number of cells that should be emptied:
– Easy– 14 of the cells
– Medium– 12 of the cells
– Hard– 34 of the cells
– Any other character– easy by default
• Randomly empty the given number of cells and fix the cells that were not emptied.

**Test** This is a tester class for my program. Its main method uses Scanner to input the size and the difficulty of the desired Sudoku puzzle.
The program then prints the original puzzle, followed by the solved version. The solution process is timed using the System.nanoTime() method and the duration is  reported at the end using milliseconds.
