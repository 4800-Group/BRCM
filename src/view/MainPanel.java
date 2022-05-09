package view;

import javax.swing.*;

import antlr.actions.cpp.ActionLexer;
import model.business.MaintainCustomerBusiness;
import model.business.RegisterActivityBusiness;
import model.business.RegisterVisitBusiness;
import model.entities.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
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
    private JList<Visit> list;
    private DefaultListModel<Visit> model;

    private JLabel text1, text2, text3, text4, text5, text6;
    private JTextField txtID, txtFirst, txtLast, txtDob, txtPhone, txtActivityID;
    private JPanel maintain;
    private JButton buttonCreate, buttonRead, buttonUpdate, buttonDelete, buttonVisit, buttonActivity;
    private JScrollPane visits;
    private Customer currentCustomer;

    public MainPanel() {
        this.init();
    }

    public void init() {
        list = new JList<Visit>();
        model = new DefaultListModel<Visit>();
        text1 = new JLabel("Bronco ID:  ");
        text2 = new JLabel("First name: ");
        text3 = new JLabel("Last name:  ");
        text4 = new JLabel("DOB:        ");
        text5 = new JLabel("Phone:      ");
        text6 = new JLabel("ActivityID: ");
        txtID = new JTextField(15);
        txtFirst = new JTextField(15);
        txtLast = new JTextField(15);
        txtDob = new JTextField(15);
        txtPhone = new JTextField(15);
        txtActivityID = new JTextField(15);
        maintain = new JPanel();
        maintain.setLayout(new BoxLayout(maintain, BoxLayout.Y_AXIS));
        visits = new JScrollPane(list);
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        final ListSelectionListener sl = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    Visit a = list.getSelectedValue();
                    List<VisitActivity> va = RegisterActivityBusiness.getInstance().list(a);
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < va.size(); i++) {
                        sb.append(va.get(i).toString());
                        sb.append("\n");
                    }
                    JOptionPane.showMessageDialog(null, sb.toString());
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
                        JOptionPane.showMessageDialog(null, "Customer created!");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                } else if (event.getSource() == buttonRead) {
                    try {
                        MaintainCustomerBusiness mb = MaintainCustomerBusiness.getInstance();
                        String broncoID = txtID.getText();
                        mb.setBroncoID(broncoID);
                        Customer customer = mb.search();
                        currentCustomer = customer;
                        model.clear();
                        for (Visit v : customer.getVisits()) {
                            model.addElement(v);
                        }
                        JOptionPane.showMessageDialog(null, customer.toString());
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                } else if (event.getSource() == buttonUpdate) {
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
                        JOptionPane.showMessageDialog(null, "Updated!");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                } else if (event.getSource() == buttonDelete) {
                    try {
                        MaintainCustomerBusiness mb = MaintainCustomerBusiness.getInstance();
                        mb.setBroncoID(txtID.getText());
                        Customer user = mb.search();
                        mb.delete(user);
                        JOptionPane.showMessageDialog(null, "Deteled!");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                } else if (event.getSource() == buttonVisit) {
                    try {
                        MaintainCustomerBusiness mb = MaintainCustomerBusiness.getInstance();
                        mb.setBroncoID(txtID.getText());
                        Customer user = mb.search();
                        RegisterVisitBusiness.getInstance().register(user);
                        model.clear();
                        for (Visit v : user.getVisits()) {
                            model.addElement(v);
                        }
                        JOptionPane.showMessageDialog(null, "Visit recorded!");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                } else if (event.getSource() == buttonActivity) {
                    try {
                        MaintainCustomerBusiness mcb = MaintainCustomerBusiness.getInstance();
                        mcb.setBroncoID(txtID.getText());
                        Customer customer = mcb.search();
                        List<Visit> visits = customer.getVisits();
                        Collections.sort(visits);
                        System.out.println(customer.getVisits());
                        MaintainActivityBusiness mab = MaintainActivityBusiness.getInstance();
                        mab.setActivityID(Integer.parseInt(txtActivityID.getText()));
                        Activity activity = mab.search();
                        RegisterActivityBusiness.getInstance().register(visits.get(0), activity);
                        JOptionPane.showMessageDialog(null, "Activity recorded!");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                }
            }
        };

        this.buttonCreate = new JButton("create");
        this.buttonCreate.addActionListener(al);

        this.buttonUpdate = new JButton("update");
        this.buttonUpdate.addActionListener(al);

        this.buttonRead = new JButton("search");
        this.buttonRead.addActionListener(al);

        this.buttonDelete = new JButton("delete");
        this.buttonDelete.addActionListener(al);

        this.buttonVisit = new JButton("visit");
        this.buttonVisit.addActionListener(al);

        this.buttonActivity = new JButton("activity");
        this.buttonActivity.addActionListener(al);

        list.setModel(model);

        list.getSelectionModel().addListSelectionListener(sl);

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        JPanel p6 = new JPanel();
        JPanel p7 = new JPanel();
        JPanel p8 = new JPanel();

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
        p6.add(text6);
        p6.add(txtActivityID);
        p6.setLayout(new FlowLayout(FlowLayout.CENTER));

        p7.add(this.buttonCreate);
        p7.add(this.buttonRead);
        p7.add(this.buttonUpdate);
        p8.add(this.buttonDelete);
        p8.add(this.buttonVisit);
        p8.add(this.buttonActivity);

        maintain.add(p1);
        maintain.add(p2);
        maintain.add(p3);
        maintain.add(p4);
        maintain.add(p5);
        maintain.add(p6);
        maintain.add(p7);
        maintain.add(p8);

        this.add(maintain);
        this.add(visits);
    }
}
