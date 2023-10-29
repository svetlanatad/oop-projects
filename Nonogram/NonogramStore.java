import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NonogramStore {

    private ArrayList<Nonogram> nonograms;

    public NonogramStore(String path) {
        path = "/Users/lanatadevosyan/Desktop/Nonograms.txt";
        try (Scanner scanner = new Scanner(new File(path))) {
            int numPuzzles = Integer.parseInt(scanner.nextLine().trim());
            nonograms = new ArrayList<>(numPuzzles);

            for (int i = 0; i < numPuzzles; i++) {
                String name = scanner.nextLine();
                int numRows = scanner.nextInt();
                int numCols = scanner.nextInt();
                scanner.nextLine();

                String rowRules = "";
                for (int j = 0; j < numRows; j++) {
                    rowRules += scanner.nextLine() + "\n";
                }

                String colRules = "";
                for (int j = 0; j < numCols; j++) {
                    colRules += scanner.nextLine() + "\n";
                }

                String solution = scanner.nextLine();

                String nonoString = "" + name + "\n" + numRows + "\n" + numCols + "\n" + rowRules + colRules + solution + "\n";
                nonograms.add(new Nonogram(nonoString));

                if (scanner.hasNextLine()) {
                    scanner.nextLine(); // skip empty line between puzzles
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Nonogram> getNonogramsSorted(){
        ArrayList<Nonogram> sorted = new ArrayList<>(nonograms);
        Collections.sort(sorted);
        return sorted;
    }
}


