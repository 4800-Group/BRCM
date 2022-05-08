package view;

import javax.swing.*;

import antlr.actions.cpp.ActionLexer;
import model.business.MaintainCustomerBusiness;
import model.entities.Customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class MainPanel extends JPanel {
    private JLabel lblBroncoID;
	
	private JButton buttonCreate;
    public MainPanel() {
        this.add(new JLabel("This is test panel " + "!!!"));
        this.lblBroncoID = new JLabel("Bronco ID: ");
        this.buttonCreate = new JButton("create");
        this.buttonCreate.setFocusable(false);
        ActionListener al = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblBroncoID.setText("100");
            }
        };
        buttonCreate.addActionListener(al);
        this.add(this.buttonCreate);
        this.add(this.lblBroncoID);
    }

}
