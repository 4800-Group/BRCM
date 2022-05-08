package model.entities;
import java.util.Date;

import javax.persistence.*;
import java.text.SimpleDateFormat;

@Entity
@Table(name="historical_price")
public class HistoricalPrice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="historical_price_id")
	private int historicalPriceID;
	
	@Column(name="price")
	private float price;
	
	@Column(name="date")
	private Date date;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name="activity_id")
    private Activity activity;
	
	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return String.format("Historical Price [Date=%s, Price=%.2f]",formatter.format(date), price);
	}

    public HistoricalPrice(float price, Date date) {
        this.price= price;
        this.date = date;
    }
    public HistoricalPrice() {}
	

    /**
     * @return int return the historicalPriceID
     */
    public int getHistoricalPriceID() {
        return historicalPriceID;
    }

    /**
     * @param historicalPriceID the historicalPriceID to set
     */
    public void setHistoricalPriceID(int historicalPriceID) {
        this.historicalPriceID = historicalPriceID;
    }

    /**
     * @return float return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return Date return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return Activity return the activity
     */
    public Activity getActivity() {
        return activity;
    }

    /**
     * @param activity the activity to set
     */
    public void setActivity(Activity activity) {
        this.activity = activity;
    }

}



