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
	
    // no auto increment
	@Id
	@Column(name="bronco_id")
	private String broncoID;

    // Customer must have
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")	
	private String lastName;

	@Column(name="phone")
	private int phone;

    // @Column(name="discount")
    // private float discount;
	
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
		return String.format("Customer [BroncoID=%s, Name=%s %s, Phone=%d, Address=%s, dob=%s", broncoID, firstName, lastName, phone, "", formatter.format(dob));
	}

    public Customer(String broncoID, String fn, String ln, int phone, Date dob) {
        this.broncoID = broncoID;
        this.firstName = fn;
        this.lastName = ln;
        this.phone = phone;
        this.dob = dob;
    }

    public Customer() {}

    /**
     * @return String return the broncoID
     */
    public String getBroncoID() {
        return broncoID;
    }

    /**
     * @param broncoID the broncoID to set
     */
    public void setBroncoID(String broncoID) {
        this.broncoID = broncoID;
    }

    /**
     * @return String return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return String return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return int return the phone
     */
    public int getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(int phone) {
        this.phone = phone;
    }

    /**
     * @return Date return the dob
     */
    public Date getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }

    /**
     * @return String return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * @return String return the office
     */
    public String getOffice() {
        return office;
    }

    /**
     * @param office the office to set
     */
    public void setOffice(String office) {
        this.office = office;
    }

    /**
     * @return String return the research
     */
    public String getResearch() {
        return research;
    }

    /**
     * @param research the research to set
     */
    public void setResearch(String research) {
        this.research = research;
    }

    /**
     * @return Date return the enterDate
     */
    public Date getEnterDate() {
        return enterDate;
    }

    /**
     * @param enterDate the enterDate to set
     */
    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
    }

    /**
     * @return Date return the gradDate
     */
    public Date getGradDate() {
        return gradDate;
    }

    /**
     * @param gradDate the gradDate to set
     */
    public void setGradDate(Date gradDate) {
        this.gradDate = gradDate;
    }

    /**
     * @return String return the major
     */
    public String getMajor() {
        return major;
    }

    /**
     * @param major the major to set
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * @return String return the minor
     */
    public String getMinor() {
        return minor;
    }

    /**
     * @param minor the minor to set
     */
    public void setMinor(String minor) {
        this.minor = minor;
    }

}
