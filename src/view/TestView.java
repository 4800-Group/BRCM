package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jboss.jandex.Main;

import model.business.MaintainCustomerBusiness;
import model.dataccess.MaintainCustomerDataAccess;
import model.entities.Customer;

@SuppressWarnings("serial")
public class TestView extends JFrame implements ActionListener {

	private JLabel lblBroncoID, lblPhone;
	
	private JButton buttonCreate, buttonRead, buttonUpdate, buttonDelete;

	private JTextField txtBroncoID, txtPhone;

	private JPanel panel1, panel2, panel3;
	
	public TestView() {

		this.initializeComponents();

		this.buildUI();
	}

	private void initializeComponents() {
		
		this.lblBroncoID = new JLabel("Bronco ID:   ");
        this.lblPhone = new JLabel("Phone:   ");

		this.buttonCreate = new JButton("create");
		this.buttonCreate.addActionListener(this);

		this.buttonRead = new JButton("read");
		this.buttonRead.addActionListener(this);

		this.buttonUpdate = new JButton("update");
		this.buttonUpdate.addActionListener(this);

		this.buttonDelete = new JButton("delete");
		this.buttonDelete.addActionListener(this);

		this.txtBroncoID = new JTextField(23);
		this.txtPhone = new JTextField(23);

		this.panel1 = new JPanel();
		this.panel1.setLayout(new FlowLayout(FlowLayout.CENTER));

		this.panel2 = new JPanel();
		this.panel2.setLayout(new FlowLayout(FlowLayout.CENTER));

		this.panel3 = new JPanel();
		this.panel3.setLayout(new FlowLayout(FlowLayout.CENTER));

	}

	private void buildUI() {

		this.panel1.add(this.lblBroncoID);
		this.panel1.add(this.txtBroncoID);

		this.panel2.add(this.lblPhone);
		this.panel2.add(this.txtPhone);

		this.panel3.add(this.buttonCreate);
		this.panel3.add(this.buttonRead);
		this.panel3.add(this.buttonUpdate);
		this.panel3.add(this.buttonDelete);

		this.getContentPane().add(panel1, BorderLayout.NORTH);
		this.getContentPane().add(panel2, BorderLayout.CENTER);
		this.getContentPane().add(panel3, BorderLayout.SOUTH);

		this.setTitle("BRCM");
		this.setBounds(350, 140, 550, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new TestView();
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == this.buttonCreate) {
			try {
				String broncoID = txtBroncoID.getText();
                int phone = Integer.parseInt(txtPhone.getText());
                Customer customer = new Customer(broncoID, "abc", "edd", phone, new Date());
                MaintainCustomerBusiness.getInstance().create(customer);
				JOptionPane.showMessageDialog (null, customer.toString());
			} catch (Exception e) {
				JOptionPane.showMessageDialog (null, e.getMessage());
			}
		} 
		else if (event.getSource() == this.buttonRead) {
			try {
                MaintainCustomerBusiness mb = MaintainCustomerBusiness.getInstance();
                mb.setBroncoID(txtBroncoID.getText());
				Customer customer = mb.search();
				JOptionPane.showMessageDialog (null, customer.toString());
			} catch (Exception e) {
				JOptionPane.showMessageDialog (null, e.getMessage());
			}
		} 
		else if (event.getSource() == this.buttonUpdate) {
			try {
                MaintainCustomerBusiness mb = MaintainCustomerBusiness.getInstance();
                mb.setBroncoID(txtBroncoID.getText());
                int phone = Integer.parseInt(txtPhone.getText());
				Customer customer = mb.search();
                customer.setPhone(phone);
                MaintainCustomerBusiness.getInstance().update(customer);
				JOptionPane.showMessageDialog (null, customer.toString());
			} catch (Exception e) {
				JOptionPane.showMessageDialog (null, e.getMessage());
			}
		} 
		else if (event.getSource() == this.buttonDelete) {
			try {
				String broncoID = txtBroncoID.getText();
				Customer user = MaintainCustomerDataAccess.getInstance().search(broncoID);
				JOptionPane.showMessageDialog (null, user.toString());
			} catch (Exception e) {
				JOptionPane.showMessageDialog (null, e.getMessage());
			}
		} 
    }
}
