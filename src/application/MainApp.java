package application;

import view.MainView;

import javax.swing.*;
import java.awt.*;

public class MainApp {

    public static void main(String[] args) {
        System.out.println("test NL");
        System.out.println("Salut");
        System.out.println("test ryad2");
        System.out.println("test nassim 2");

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MainView();
            }
        });

    }

}
