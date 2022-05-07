package model.business;
import java.sql.SQLException;

import model.dataccess.MaintainCustomerDataAccess;
import model.dataccess.MaintainPriceDataAccess;
import model.entities.*;

public class MaintainPriceBusiness {
    private int priceID;

    // singleton implementation
    private static MaintainPriceBusiness instance;
	private MaintainPriceBusiness () {}
    public static MaintainPriceBusiness getInstance() {
        return instance = instance == null ? new MaintainPriceBusiness() : instance;
    }

    public void create(HistoricalPrice customer) throws SQLException {
        // rules
        MaintainPriceDataAccess.getInstance().create(customer);
    }

    public HistoricalPrice search() throws SQLException {
        return MaintainPriceDataAccess.getInstance().search(priceID);
    }

    public void update(HistoricalPrice customer) throws SQLException {
        // rules
        MaintainPriceDataAccess.getInstance().update(customer);
    }

    public void delete(HistoricalPrice customer) throws SQLException {
        MaintainPriceDataAccess.getInstance().delete(customer);
    }

   


    /**
     * @return int return the priceID
     */
    public int getPriceID() {
        return priceID;
    }

    /**
     * @param priceID the priceID to set
     */
    public void setPriceID(int priceID) {
        this.priceID = priceID;
    }

}
