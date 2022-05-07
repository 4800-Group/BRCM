package model.business;
import java.sql.SQLException;

import model.dataccess.MaintainCustomerDataAccess;
import model.entities.*;

public class MaintainCustomerBusiness {
    private String broncoID;

    // singleton implementation
    private static MaintainCustomerBusiness instance;
	private MaintainCustomerBusiness () {}
    public static MaintainCustomerBusiness getInstance() {
        return instance = instance == null ? new MaintainCustomerBusiness() : instance;
    }

    public void create(Customer customer) throws SQLException {
        // rules
        MaintainCustomerDataAccess.getInstance().create(customer);
    }

    public Customer search() throws SQLException {
        if (broncoID == null) return null;
        return MaintainCustomerDataAccess.getInstance().search(broncoID);
    }

    public void update(Customer customer) throws SQLException {
        // rules
        MaintainCustomerDataAccess.getInstance().update(customer);
    }

    public void delete(Customer customer) throws SQLException {
        MaintainCustomerDataAccess.getInstance().delete(customer);
    }

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

}
