package view;

import javax.swing.*;

import antlr.actions.cpp.ActionLexer;
import model.business.MaintainCustomerBusiness;
import model.entities.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.hibernate.engine.transaction.jta.platform.internal.BorlandEnterpriseServerJtaPlatform;

import model.business.MaintainActivityBusiness;
import model.business.MaintainCustomerBusiness;
import model.entities.Activity;
import model.entities.Customer;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

public class MainPanel extends JPanel {
private JList<Activity> list = new JList<Activity>();
    private DefaultListModel<Activity> model = new DefaultListModel<Activity>();

    private JLabel text1, text2, text3, text4,text5;
    private JTextField txtID, txtFirst, txtLast, txtDob, txtPhone;
    private JPanel maintain, activities;
    private JButton buttonCreate, buttonRead, buttonUpdate, buttonDelete;
    private JScrollPane visits;
    private Customer currentCustomer;

    public MainPanel() {
        this.init();
    }

    public void init() {
        list = new JList<Activity>();
        model = new DefaultListModel<Activity>();
        text1 = new JLabel("Bronco ID:  ");
        text2 = new JLabel("First name: ");
        text3 = new JLabel("Last name:  ");
        text4 = new JLabel("DOB:        ");
        text5 = new JLabel("Phone:      ");
        txtID = new JTextField(15);
        txtFirst = new JTextField(15);
        txtLast = new JTextField(15);
        txtDob = new JTextField(15);
        txtPhone = new JTextField(15);
        maintain = new JPanel();
        activities = new JPanel();
        activities.setLayout(new BoxLayout(activities, BoxLayout.Y_AXIS));
        maintain.setLayout(new BoxLayout(maintain, BoxLayout.Y_AXIS));
        visits = new JScrollPane(list);
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        final ListSelectionListener sl = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    Activity a = list.getSelectedValue();
                } catch (Exception ee) {
                }
            }
        };

        ActionListener al = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (event.getSource() == buttonCreate) {
			try {
				String broncoID = txtID.getText();
                Date dob = new Date();
                String fn = txtFirst.getText();
                String ln = txtLast.getText();
                String phone = txtPhone.getText();
                Customer customer = new Customer(broncoID, fn, ln, phone, dob);
                MaintainCustomerBusiness.getInstance().create(customer);
				JOptionPane.showMessageDialog (null, "Customer created!");
			} catch (Exception e) {
				JOptionPane.showMessageDialog (null, e.getMessage());
			}
		} 
		else if (event.getSource() == buttonRead) {
			try {
                MaintainCustomerBusiness mb = MaintainCustomerBusiness.getInstance();
				String broncoID = txtID.getText();
                mb.setBroncoID(broncoID);
				Customer customer = mb.search();
                currentCustomer = customer;
				JOptionPane.showMessageDialog (null, customer.toString());
			} catch (Exception e) {
				JOptionPane.showMessageDialog (null, e.getMessage());
			}
		} 
		else if (event.getSource() ==buttonUpdate) {
			try {
                MaintainCustomerBusiness mb = MaintainCustomerBusiness.getInstance();
                mb.setBroncoID(txtID.getText());
				Customer customer = mb.search();
				String broncoID = txtID.getText();
                Date dob = new Date();
                String fn = txtFirst.getText();
                String ln = txtLast.getText();
                String phone = txtPhone.getText();
                customer.setFirstName(fn);
                customer.setLastName(ln);
                customer.setPhone(phone);
                customer.setDob(dob);
                mb.update(customer);
				JOptionPane.showMessageDialog (null, "Updated!");
			} catch (Exception e) {
				JOptionPane.showMessageDialog (null, e.getMessage());
			}
		} 
		else if (event.getSource() == buttonDelete) {
			try {
                MaintainCustomerBusiness mb = MaintainCustomerBusiness.getInstance();
                mb.setBroncoID(txtID.getText());
				Customer user = mb.search();
                mb.delete(user);
				JOptionPane.showMessageDialog (null, "Deteled!");
			} catch (Exception e) {
				JOptionPane.showMessageDialog (null, e.getMessage());
			}
		} 

            }
        };

        this.buttonCreate = new JButton("create");
        this.buttonCreate.addActionListener(al);

        this.buttonUpdate = new JButton("search");
        this.buttonUpdate.addActionListener(al);

        this.buttonRead = new JButton("update");
        this.buttonRead.addActionListener(al);

        this.buttonDelete = new JButton("delete");
        this.buttonDelete.addActionListener(al);

        list.setModel(model);
        try {
            List<Activity> temp = MaintainActivityBusiness.getInstance().list();
            for (Activity a : temp) {
                model.addElement(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        list.getSelectionModel().addListSelectionListener(sl);

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        JPanel p6 = new JPanel();

        p1.add(text1);
        p1.add(txtID);
        p1.setLayout(new FlowLayout(FlowLayout.CENTER));
        p2.add(text2);
        p2.add(txtFirst);
        p2.setLayout(new FlowLayout(FlowLayout.CENTER));
        p3.add(text3);
        p3.add(txtLast);
        p3.setLayout(new FlowLayout(FlowLayout.CENTER));
        p4.add(text4);
        p4.add(txtDob);
        p4.setLayout(new FlowLayout(FlowLayout.CENTER));
        p5.add(text5);
        p5.add(txtPhone);
        p5.setLayout(new FlowLayout(FlowLayout.CENTER));

        p6.add(this.buttonCreate);
        p6.add(this.buttonRead);
        p6.add(this.buttonUpdate);
        p6.add(this.buttonDelete);

        maintain.add(p1);
        maintain.add(p2);
        maintain.add(p3);
        maintain.add(p4);
        maintain.add(p5);
        maintain.add(p6);

        this.add(maintain);
        this.add(visits);
        this.add(activities);
    }
}
