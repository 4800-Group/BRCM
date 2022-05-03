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
	
	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return String.format("Historical Price [Date=%s, Price=%.2f]",formatter.format(date), price);
	}
	
}



