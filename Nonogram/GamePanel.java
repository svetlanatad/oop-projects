import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//Acknowledged chat gpt collaboration for this whole class o(TヘTo)

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


    public GamePanel(Nonogram n) {
        this.nonogram = n;
        this.rows = n.width();
        this.columns = n.height();
        this.extraNumberOfRows = n.columnRuleMaxSize() - rows;
        this.extraNumberOfColumns = n.rowRuleMaxSize() - columns;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX() - xPadding;
                int y = e.getY() - yPadding;
                int cellX = x / singleCell;
                int cellY = y / singleCell;
                if (cellX >= 0 && cellY >= 0 && cellX < columns && cellY < rows) {
                    nonogram.flip(cellY, cellX);
                    isSolved = false;
                    repaint();
                }
            }
        });



    }
    public Nonogram getNonogram() {
        return nonogram;
    }
    public void setNonogram(Nonogram n) {
        this.nonogram = n;
        this.rows = n.width();
        this.columns = n.height();
        this.extraNumberOfRows = n.rowRuleMaxSize() - rows;
        this.extraNumberOfColumns = n.columnRuleMaxSize() - columns;
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Compute the size of a single cell based on window size and number of rows/columns
        int singleCell = (int) (Math.min(getWidth(), getHeight()) /
                (Math.max(rows + nonogram.width(), columns + nonogram.height())) * 0.98);

        // Draw the grid
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                // Compute the coordinates of the cell
                int x = col * singleCell + nonogram.height() * singleCell;
                int y = row * singleCell + nonogram.width() * singleCell;

                // Determine the color of the cell based on the solution
                Color cellColor;
                //TODO
                if (this.nonogram.board[row][col]) {
                    cellColor = Color.BLACK;
                } else {
                    cellColor = Color.WHITE;
                }

                // Draw the cell
                //TODO
               g.setColor(cellColor);
                g.fillRect(x, y, singleCell, singleCell);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, singleCell, singleCell);
            }
        }

        // Draw a string indicating if the puzzle is solved
        if (showIfIsSolved) {
            //TODO
            String solvedString = "Solved: " + nonogram.checkIfSolved();
            FontMetrics fm = g.getFontMetrics();
            int stringWidth = fm.stringWidth(solvedString);
           g.drawString(solvedString, (getWidth() - stringWidth) / 2, getHeight() - fm.getHeight() / 2);
        }
    }





}

//Thank you for checking mine and chat's homework(っ˘̩╭╮˘̩)っ  T.T