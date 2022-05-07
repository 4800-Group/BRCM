package model.entities;
import java.util.Date;
import javax.persistence.*;
import java.text.SimpleDateFormat;

@Entity
@Table(name="address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="address_id")
	private int addressID;
	
	@Column(name="street")
	private String street;
	
	@Column(name="number")	
	private int number;

	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="zip_code")
	private int zipCode;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="bronco_id")
    private Customer customer;
	
	@Override
	public String toString() {
		return String.format("%d %d %s %s %s %d",addressID, number, street, city, state, zipCode);
	}

    public Address(int number, String street, String city, String state, int zipCode) {
        this.number = number;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.street = street;
    }

    public Address() {}

    /**
     * @return String return the addressID
     */
    public int getAddressID() {
        return addressID;
    }

    /**
     * @param addressID the addressID to set
     */
    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    /**
     * @return String return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return int return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * @return String return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return String return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return int return the zipCode
     */
    public int getZipCode() {
        return zipCode;
    }

    /**
     * @param zipCode the zipCode to set
     */
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * @return Customer return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}



