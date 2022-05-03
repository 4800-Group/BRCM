package model.entities;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.SimpleDateFormat;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bronco_id")
	private String BroncoID;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")	
	private String lastName;

	@Column(name="phone")
	private int phone;
	
	// @Column(name="address")
	// private Address address;
	
	@Column(name="dob")
	private Date dob;

    // Professor fields
    @Column(name="department")
	private String department;

	@Column(name="office")
	private String office;

	@Column(name="research")
	private String research;

    // Student fields
    @Column(name="enter_date")
	private Date enterDate;
	
	@Column(name="grad_date")
	private Date gradDate;
	
	@Column(name="major")
	private String major;

	@Column(name="minor")
	private String minor;
	
	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return String.format("Customer [BroncoID=%s, Name=%s %s, Phone=%d, Address=%s, dob=%s", BroncoID, firstName, lastName, phone, "", formatter.format(dob));
	}
}
