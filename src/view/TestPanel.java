package view;

import javax.swing.*;

public class TestPanel extends JPanel{
    public TestPanel(int i) {
        this.add(new JLabel("This is test panel " + i + "!!!"));
    }
}
