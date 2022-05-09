package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.*;

import org.jboss.jandex.Main;

public class MainView extends JFrame {
    private JTabbedPane menu;
    private MainPanel mainPanel;
    private ActivityPanel activityPanel;

    public MainView() {
        this.init();
        this.build();
    }

    private void init() {
        this.menu = new JTabbedPane();
        this.mainPanel = new MainPanel();
        this.activityPanel = new ActivityPanel();

    }

    private void build() {
        this.menu.add("Main", this.mainPanel);
        this.menu.add("Activities", this.activityPanel);

        this.menu.setFocusable(false);
		this.getContentPane().add(this.menu);
		this.setTitle("BRCM");
		this.setBounds(350, 140, 800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
    }

    public static void main(String[] args) {
        new MainView();
    }
}