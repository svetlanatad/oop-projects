**Term/Year:** Fall 2022

**Subject Code and Course Number**: CS120 Intro to OOP, Sections B & D

**University and Faculty:** American University of Armenia, CSE

**Instructor name**  Monika Stepanyan

Refer to Nonogram.mp4 to see how it looks like :) 
Nonogram is a logic puzzle where the goal is to paint cells in a grid to create a picture. The puzzle is solved by using the numbers (rules) given for each row and column to determine which cells should be painted. Make sure you familiarize yourself with the rules of the puzzle before starting to work on the assignment.
**Nonogram**:  Creates a class Nonogram that will represent an instance of a puzzle. Objects of this class should be comparable with each other. Each puzzle will include the following instance variables:
• String name representing the name of the puzzle.
• boolean two-dimensional array board representing the cells of the puzzle. A value of true
indicates that a cell is painted.
• boolean two-dimensional array solution representing the solution configuration for this puz- zle.
• integer two-dimensional ragged array rowRules representing all of the row rules.
• integer two-dimensional ragged array columnRules representing all of the column rules.
It should also include the following methods:
• width() - Returns the width of the board.
• height() - Returns the height of the board.
• columnRuleMaxSize() - Returns the maximum length of any rule in the columnRules array (i.e., the maximum number of blocks in any column).
• public int rowRuleMaxSize() - Returns the maximum length of any rule in the rowRules array.
• getCell(int row, int column) - Returns the value of the cell at the given row and column.
• getRowRule(int i) - Returns the rule at the given index i in the rowRules array.
• getColumnRule(int i) - Returns the rule at the given index i in the columnRules array.
• flip(int row, int col) - Flips (colors or clears) the value of the cell at the given row and column.
• setCells(boolean[][] arr) - Sets the cells in the board array to the values in the given 2D boolean array.
• clear() - Clears the board. Can use setCells(...)
• fillWithSolution() - Sets the cells in the board to the values in the solution.
• toString() - Returns the name of the Nonogram object.
• compareTo(Nonogram nonogram) - Returns the difference between the sum of the width and height of this object and the sum of the width and height of the given object.

• checkIfSolved() - This method checks if the current state of the board satisfies the row and column rules. If all rules are satisfied, the method returns true, otherwise it returns false.
• Nonogram(String configuration): Constructor that takes a string representation of the nonogram and initializes its attributes. The format of the argument string is described below (additionally refer to the file “example.txt”):
name of the puzzle number of columns number of rows
row rules column rules solution
**NonogramStore**: Creates class NonogramStore representing a collection of Nonogram puzzles stored in an ArrayList.
It should include the following methods:
• public NonogramStore(String path): A constructor that takes a file path as input and reads Nonogram puzzles from a file. It stores each Nonogram puzzle as a Nonogram object in the nonograms ArrayList. The format of the file is described below (additionally refer to the file “Nonograms.txt”):
number of puzzles in the file
description of puzzle #1 according to the format described for Nonogram constructor description of puzzle #2
...
description of puzzle #n
• public ArrayList<Nonogram> getNonogramsSorted(): A method that returns a sorted Ar- rayList of Nonogram objects based on their natural ordering (defined by compareTo). It cre- ates a copy of the nonograms ArrayList, sorts the copy using the Collections.sort(...) method, and returns the sorted copy.
Acknowledgment: The following repository was used to compile the Nonograms.txt file.
The next tasks deal with the design of the GUI component for the game. You are more than welcome to make the application look more appealing.
2

**GUIPuzzle**: Creates a class GUIPuzzle that is a Jframe and represents the main window of the application. This class includes two attributes– a GamePanel (described in the next task) and a NonogramStore.
There are three main sections of this window: the game panel, the configurations panel and the control panel. Add the following to GUIPuzzle:
       private GamePanel gamePanel;
       private NonogramStore store;
       public GUIPuzzle() {
           super("Nonogram");
           store = new NonogramStore("path to the Nonogram.txt file");
           setDefaultCloseOperation(EXIT_ON_CLOSE);
           setSize(1024,768);
           add(createConfigurationsPanel(), BorderLayout.WEST);
           add(createControlPanel(), BorderLayout.SOUTH);
           add(createGamePanel(), BorderLayout.CENTER);
}
       private void addBorder(JComponent component, String title) {
           Border etch = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
           Border tb = BorderFactory.createTitledBorder(etch, title);
           component.setBorder(tb);
}
       private JPanel createGamePanel() {
           // TODO
           return new JPanel(); // temporary return
       }
       private JPanel createConfigurationsPanel() {
           JPanel conf = new JPanel();
           addBorder(conf, "Puzzles");
           // TODO
           return conf;
       }
       private JPanel createControlPanel() {
           JPanel ctrl =  new JPanel();
           addBorder(ctrl, "Controls");
           // TODO
           return ctrl;
       }
3

Complete createControlPanel() by creating
• JButton “Is Solved” that will check if the board is solved,
• JButton “Show Solution” that will show solution,
• JButton “Clear” that will clear the current nonogram board,
• JButton “Save As Image” that will save the current state of the board as a .png image in the same directory where this class is located, using the name defined in (see below)
• TextField for naming the image to export
• JLabel that reads “Name the image you want to save:” that explains the purpose of the text
field.
All the components should run horizontally in two rows as per the screenshot above. Add ActionListeners using anonymous classes to all buttons. Leave the actionPerformed methods empty for now. You
will get back to them after completing the next class.
Complete createConfigurationsPanel() to produce the WEST panel containing the list of puz- zles. This is actually a JPanel that contains a JScrollPane that contains a JList: you are expected to use the Java API documentation to work out how to use these elements. The JScrollPane au- tomatically provides scroll bars whenever the components it contains cannot be displayed. The JList it contains should be initialised using store and should present the configurations sorted. Add a ListSelectionListener to the Jlist using an anonymous class.
**GamePanel**:  Creates a class Gamepanel that will be responsible for drawing the puzzle. Here is a starting point:
       public class GamePanel extends JPanel {
           protected Nonogram nonogram; //puzzle to draw
           private int rows; //number of rows of the puzzle
           private int columns; //number of columns
           private int extraNumberOfRows; //maximum size of any single column rule
           private int extraNumberOfColumns; //maximum size of any single row rule
           private int xPadding; //horizontal padding size
           private int yPadding; //vertical padding size
           private int singleCell; //dimensions of a single cell
           public static boolean showIfIsSolved; //whether a string should be drawn that says
           //if the board is solved
           public static boolean isSolved; //shows if the board is solved
           protected void paintComponent(java.awt.Graphics g) {
               // Paint the background white
               g.setColor(java.awt.Color.WHITE);
               g.fillRect(0, 0, this.getWidth(), this.getHeight());
               // Sample drawing statements
               g.setColor(Color.BLACK);
               g.drawRect(200, 200, 30, 30);
               g.setColor(Color.LIGHT_GRAY);
               g.fillRect(140, 140, 30, 30);
               g.fillRect(260, 140, 30, 30);
               g.setColor(Color.BLACK);
               g.drawLine(150, 300, 280, 300);
               g.drawString("@@@", 135,120);
               Font font = g.getFont();
               g.setFont(font.deriveFont(2.0f * font.getSize()));
               g.drawString("@@@", 255,120);
} }
The code above includes some example statements that you will need to remove later. 4

 Add the following functionality:
• GamePanel(Nonogram n) - initializes all the first five instance variables. Do not make deep copies in any methods of this class. Adds a MouseListener to this that is an instance of an anonymous class. the mouseClicked method should flip a value of a cell based on the coordinates of the click and then should call repaint(). Each time when a value is flipped the static instance variables should be set to false.
• getNonogram() - returns the instance variable.
• setNonogram(Nonogram n)-re-initializesallthefirstfiveinstancevariablesandcallsrepaint()
• paintComponent(java.awt.Graphics g) - draws the nonogram. Based on the width and height of the window, computes the values for the remaining instance variables. SingleCell value is computed as follows:
       singleCell = (int)(Math.min(getWidth(), getHeight())/
       (Math.max(rows+numberOfRowCells, columns+numberOfColumnCells))*0.98);
If showIfIsSolved is true, also draws a string indicating if the puzzle isSolved (refer to the video for approximate alignment).
Now let's go back to GUIPuzzle and
• finalize the method createGamePanel() by initializing the gamePanel using the first puzzle
in the store.
• finalize the method valueChanged of the ListSelectionListener so that each time a dif- ferent puzzle instance is selected from the store the setNonogram() method is invoked. The previous puzzle is cleared and the static instance variables are set to false.
• finalize the method actionPerformed of the top three buttons in the control panel. Make sure that all of the invoke repaint() in the end.
• finalize the method actionPerformed of the save button using the following code as a base:
       // Initialize width and height beforehand
       BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
       // Set the color of each pixel based on the value of the boolean matrix using method.
       // You can use any colors you like
       image.setRGB(x, y, new Color(49, 119, 115).getRGB());
       // Write the image to a file
       try {
           ImageIO.write(image, "png", new File("Path where you want to save the file"
           + name of the file +".png"));
       } catch (IOException e) {
... }