
package view;

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

public class ActivityPanel extends JPanel {
    private JList<Activity> list = new JList<Activity>();
    private DefaultListModel<Activity> model = new DefaultListModel<Activity>();

    private JLabel text1, text2, text3, id, name, price;
    private JLabel text4, text5, text6;
    private JTextField txtID, txtName, txtPrice;
    private JPanel info, maintain;
    private JButton buttonCreate, buttonUpdate, buttonDelete;
    private JScrollPane scroll;

    public ActivityPanel() {
        this.init();
    }

    public void init() {
        list = new JList<Activity>();
        model = new DefaultListModel<Activity>();
        text1 = new JLabel("ID:    ");
        text2 = new JLabel("Name:  ");
        text3 = new JLabel("Price: ");
        text4 = new JLabel("ID:    ");
        text5 = new JLabel("Name:  ");
        text6 = new JLabel("Price: ");
        txtID = new JTextField(15);
        txtName = new JTextField(15);
        txtPrice = new JTextField(15);
        id = new JLabel();
        name = new JLabel();
        price = new JLabel();
        maintain = new JPanel();
        info = new JPanel();
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
        maintain.setLayout(new BoxLayout(maintain, BoxLayout.Y_AXIS));
        scroll = new JScrollPane(list);
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        final ListSelectionListener sl = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    Activity a = list.getSelectedValue();
                    id.setText("" + a.getActivityID());
                    name.setText("" + a.getName());
                    price.setText("" + a.getCurrentPrice());
                } catch (Exception ee) {
                    id.setText("");
                    name.setText("");
                    price.setText("");
                }
            }
        };

        ActionListener al = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (event.getSource() == buttonCreate) {
                    try {
                        String name = txtName.getText();
                        float price = Float.parseFloat(txtPrice.getText());
                        Activity a = new Activity(name, price);
                        MaintainActivityBusiness.getInstance().create(a);
                        model.addElement(a);
                        JOptionPane.showMessageDialog(null, "Activity created!");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                } else if (event.getSource() == buttonUpdate) {
                    try {
                        MaintainActivityBusiness mb = MaintainActivityBusiness.getInstance();
                        Activity a = list.getSelectedValue();
                        String name = txtName.getText();
                        float price = Float.parseFloat(txtPrice.getText());
                        a.setName(name);
                        a.setCurrentPrice(price);
                        mb.update(a);
                        sl.valueChanged(null);
                        JOptionPane.showMessageDialog(null, "Updated!");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                } else if (event.getSource() == buttonDelete) {
                    try {
                        MaintainActivityBusiness mb = MaintainActivityBusiness.getInstance();
                        mb.delete(list.getSelectedValue());
                        int selectedIndex = list.getSelectedIndex();
                        if (selectedIndex != -1) {
                            model.removeElement(list.getSelectedValue());
                        }
                        JOptionPane.showMessageDialog(null, "Deleted!");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        this.buttonCreate = new JButton("create");
        this.buttonCreate.addActionListener(al);

        this.buttonUpdate = new JButton("update");
        this.buttonUpdate.addActionListener(al);

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

        p1.add(text1);
        p1.add(id);
        p1.setLayout(new FlowLayout(FlowLayout.CENTER));
        p2.add(text2);
        p2.add(name);
        p2.setLayout(new FlowLayout(FlowLayout.CENTER));
        p3.add(text3);
        p3.add(price);
        p3.setLayout(new FlowLayout(FlowLayout.CENTER));

        info.add(p2);
        info.add(p3);
        info.add(p1);

        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        JPanel p6 = new JPanel();

        p4.add(text5);
        p4.add(txtName);
        p4.setLayout(new FlowLayout(FlowLayout.CENTER));
        p5.add(text6);
        p5.add(txtPrice);
        p5.setLayout(new FlowLayout(FlowLayout.CENTER));

        p6.add(buttonCreate);
        p6.add(buttonUpdate);
        p6.add(buttonDelete);

        maintain.add(p4);
        maintain.add(p5);
        maintain.add(p6);

        this.add(scroll);
        this.add(info);
        this.add(maintain);
    }
}
