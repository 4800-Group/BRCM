package model.entities;
import java.util.Date;
import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.text.html.FormSubmitEvent;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Entity
@Table(name="visit")
public class Visit implements Comparable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="visit_id")
	private int visitID;
	
	@Column(name="time")
	private Timestamp time;

	@Column(name="status")
	private String status;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name="bronco_id")
    private Customer customer;

    @OneToMany(mappedBy="visit", cascade = {CascadeType.ALL})
    private List<VisitActivity> visitActivities;


	@Override
	public String toString() {
		return String.format("Visit [VisitID=%d, Time= %s]", visitID, time.toString());
	}

    public Visit(Customer customer) {
        this.customer = customer;
        this.status = "Complete"; 
        customer.addVisit(this);
        this.time = new Timestamp(new Date().getTime());
    }

    public Visit() {}

    


    /**
     * @return int return the visitID
     */
    public int getVisitID() {
        return visitID;
    }

    /**
     * @param visitID the visitID to set
     */
    public void setVisitID(int visitID) {
        this.visitID = visitID;
    }

    public Timestamp getTime() {
        return time;
    }
    /**
     * @param time the time to set
     */
    public void setTime(Timestamp time) {
        this.time = time;
    }

    /**
     * @return String return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
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

    /**
     * @return List<VisitActivity> return the visitActivities
     */
    public List<VisitActivity> getVisitActivities() {
        return visitActivities;
    }

    /**
     * @param visitActivities the visitActivities to set
     */
    public void setVisitActivities(List<VisitActivity> visitActivities) {
        this.visitActivities = visitActivities;
    }

    @Override
    public int compareTo(Object o) {
        if (time.before(((Visit) o).getTime())) {
            return 1;
        }
        else {
            return -1;
        }
    }

}



