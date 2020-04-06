package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MainView extends JFrame {

    public MainView() {
        this.setTitle("TP3 log 121");
        init();
        this.setVisible(true);
    }

    private void init() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenX = screenSize.width;
        int screenY = screenSize.height;

        JMenuBar menuBar = new JMenuBar();
        JMenu menuFichier = new JMenu("Fichier");
        JMenu menuEdit = new JMenu("Edit");
        menuBar.add(menuFichier);
        menuBar.add(menuEdit);
        JMenuItem menuItemOuvrir = new JMenuItem("Ouvrir");
        JMenuItem menuItemSaveAs = new JMenuItem("Enregistrer sous");
        JMenuItem menuItemUndo = new JMenuItem("Undo");

        menuItemOuvrir.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ev) {
                try {

                    JFileChooser jFileChooser = new JFileChooser(System.getProperty("user.home"));
                    jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp");
                    jFileChooser.addChoosableFileFilter(fileFilter);
                    jFileChooser.setFileFilter(fileFilter);

                    if(jFileChooser.showOpenDialog(menuBar) == JFileChooser.APPROVE_OPTION) {
                        File file = jFileChooser.getSelectedFile();
                        Image img = ImageIO.read(file);
                        ImageIcon imageIcon = new ImageIcon(img);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        menuFichier.add(menuItemOuvrir);
        menuFichier.add(menuItemSaveAs);
        menuEdit.add(menuItemUndo);

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.cyan);
        centerPanel.setLayout(new GridLayout(1, 2));
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.orange);
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.GRAY);
        centerPanel.add(leftPanel);
        centerPanel.add(rightPanel);
        this.getContentPane().add(BorderLayout.CENTER, centerPanel);


        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout());
        southPanel.setBackground(Color.pink);
        //southPanel.setSize(80,80);

        JPanel thumbPanel = new JPanel();
        int thumbHeight = (int) (Math.round(screenY * 0.20));
        int thumbWidth = thumbHeight;
        thumbPanel.setPreferredSize(new Dimension(thumbWidth, thumbHeight));
        thumbPanel.setBackground(Color.LIGHT_GRAY);
        southPanel.add(thumbPanel);
        this.getContentPane().add(BorderLayout.SOUTH, southPanel);

        this.getContentPane().add(BorderLayout.NORTH, menuBar);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(screenSize);
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.pack();
    }

}
