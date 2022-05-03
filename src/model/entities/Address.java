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
@Table(name="address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="address_id")
	private String addressID;
	
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
	
	@Override
	public String toString() {
		return String.format("%d %s %s %s %d", number, street, city, state, zipCode);
	}
	
}



