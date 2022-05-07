package model.entities;
import java.util.Date;
import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.List;

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

    @OneToMany(mappedBy="activity",cascade = {CascadeType.PERSIST})
    private List<HistoricalPrice> historicalPrices;

    @OneToMany(mappedBy = "activity", cascade = {CascadeType.PERSIST})
    private List<VisitActivity> visitActivities;

	@Override
	public String toString() {
		return String.format("Activity [ActivityID=%d, Name=%s, Price=%.2f", activityID, name, currentPrice);
	}

    public Activity() {}
	

    


    /**
     * @return int return the activityID
     */
    public int getActivityID() {
        return activityID;
    }

    /**
     * @param activityID the activityID to set
     */
    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return float return the currentPrice
     */
    public float getCurrentPrice() {
        return currentPrice;
    }

    /**
     * @param currentPrice the currentPrice to set
     */
    public void setCurrentPrice(float currentPrice) {
        this.currentPrice = currentPrice;
    }

    /**
     * @return List<HistoricalPrice> return the historicalPrices
     */
    public List<HistoricalPrice> getHistoricalPrices() {
        return historicalPrices;
    }

    /**
     * @param historicalPrices the historicalPrices to set
     */
    public void setHistoricalPrices(List<HistoricalPrice> historicalPrices) {
        this.historicalPrices = historicalPrices;
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

}



