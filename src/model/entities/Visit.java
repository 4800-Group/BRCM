package model.entities;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.text.html.FormSubmitEvent;

import java.text.SimpleDateFormat;

@Entity
@Table(name="visit")
public class Visit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="visit_id")
	private int visitID;
	
	@Column(name="time")
	private Date time;
	
	// @Column(name="total_price")	
	// private float totalPrice;
	
	@Override
	public String toString() {
		return String.format("Visit [VisitID=%d, Time= %s", visitID, time.toString());
	}

    public Visit(Customer customer) {
        // this.customer = customer;
        this.time = new Date();
    }
}



