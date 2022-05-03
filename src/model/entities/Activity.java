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
@Table(name="activity")
public class Activity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="activity_id")
	private int activityID;
	
	@Column(name="name")
	private String name;
	
	@Column(name="current_price")	
	private float currentPrice;

	@Override
	public String toString() {
		return String.format("Activity [ActivityID=%d, Name=%s, Price=%.2f", activityID, name, currentPrice);
	}
	
}



