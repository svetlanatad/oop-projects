import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

//Acknowledged chat gpt collaboration for this whole class (｡•́︿•̀｡)

public class GUIPuzzle extends JFrame {

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
    public Component createGamePanel() {


        Nonogram puzzle = store.getNonogramsSorted().get(0);
        gamePanel = new GamePanel(puzzle);
        getContentPane().add(gamePanel, BorderLayout.CENTER);
        pack();
        return null;
    }


    private JPanel createConfigurationsPanel() {
        // Create the panel with a titled border
        JPanel configurationsPanel = new JPanel();
        addBorder(configurationsPanel, "Puzzles");

        // Initialize JList with sorted nonograms from NonogramStore
        ArrayList<Nonogram> nonograms = store.getNonogramsSorted();
        DefaultListModel<Nonogram> listModel = new DefaultListModel<>();
        for (Nonogram nonogram : nonograms) {
            listModel.addElement(nonogram);
        }
        JList<Nonogram> nonogramList = new JList<>(listModel);

        // Add ListSelectionListener to JList using anonymous class
        nonogramList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (!e.getValueIsAdjusting()) {
                    Nonogram selected = nonogramList.getSelectedValue();
                    if (selected != null) {
                        nonograms.clear();

                        gamePanel.setNonogram(selected);
                    }
                }
            }

        });

        // Create JScrollPane and add JList to it
        JScrollPane scrollPane = new JScrollPane(nonogramList);

        // Add JScrollPane to configurationsPanel
        configurationsPanel.add(scrollPane);

        // Return configurationsPanel
        return configurationsPanel;
    }




    private JPanel createControlPanel() {
        JPanel ctrl = new JPanel();
        addBorder(ctrl, "Controls");

        // Create buttons
        JButton isSolvedBtn = new JButton("Is Solved");
        JButton showSolutionBtn = new JButton("Show Solution");
        JButton clearBtn = new JButton("Clear");
        JButton saveAsImageBtn = new JButton("Save As Image");

        // Create text field and label
        JTextField imageNameField = new JTextField(15);
        JLabel imageNameLabel = new JLabel("Name the image you want to save:");

        // Add components to the panel
        ctrl.setLayout(new GridLayout(2, 3, 5, 5));
        ctrl.add(isSolvedBtn);
        ctrl.add(showSolutionBtn);
        ctrl.add(clearBtn);
        ctrl.add(imageNameLabel);
        ctrl.add(imageNameField);
        ctrl.add(saveAsImageBtn);

        // Add ActionListeners to the buttons
        isSolvedBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamePanel.repaint();
            }
        });


        showSolutionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamePanel.repaint();            }
        });

        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamePanel.repaint();            }
        });

        saveAsImageBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the current nonogram and its solution
                Nonogram nono = gamePanel.getNonogram();
                boolean[][] solution = nono.getSolution();

                // Initialize width and height
                int width = solution.length;
                int height = solution[0].length;

                // Create an image
                BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

                // Set the color of each pixel based on the solution
                for (int x = 0; x < width; x++) {
                    for (int y = 0; y < height; y++) {
                        if (solution[x][y]) {
                            // Set pixel to black if the cell is filled
                            image.setRGB(x, y, Color.BLACK.getRGB());
                        } else {
                            // Set pixel to white if the cell is not filled
                            image.setRGB(x, y, Color.WHITE.getRGB());
                        }
                    }
                }

                // Write the image to a file
                try {
                    File file = new File("nonogram.png");
                    ImageIO.write(image, "png", file);
                    System.out.println("Saved image to " + file.getAbsolutePath());
                } catch (IOException ex) {
                    System.err.println("Error saving image: " + ex.getMessage());
                }
            }
        });

        return ctrl;
    }


}
/* // Initialize width and height beforehand
                BufferedImage image = new BufferedImage(width(), height(), BufferedImage.TYPE_INT_RGB);
                // Set the color of each pixel based on the value of the boolean matrix using method.
                // You can use any colors you like
                image.setRGB(x, y, new Color(49, 119, 115).getRGB());
                // Write the image to a file
                try {
                    ImageIO.write(image, "png", new File("/Users/lanatadevosyan/Desktop/Nonograms.txt"
                            + "Nono" +".png"));
                } catch (IOException exc) {
                    exc.getMessage();
                }
            }

 */