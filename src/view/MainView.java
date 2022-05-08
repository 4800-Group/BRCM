package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.*;

public class MainView extends JFrame {
    private JTabbedPane menu;

    public MainView() {
        this.init();
        this.build();
    }

    private void init() {
        this.menu = new JTabbedPane();
    }

    private void build() {
        this.menu.add("TestPanel", new TestPanel(2));
        this.menu.add("Sup", new TestPanel(1));
        this.menu.setFocusable(false);
		this.getContentPane().add(this.menu);
		this.setTitle("BRCM");
		this.setBounds(350, 140, 550, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
    }

    public static void main(String[] args) {
        new MainView();
    }
}
