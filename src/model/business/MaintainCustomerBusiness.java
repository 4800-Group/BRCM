package model.business;
import java.sql.SQLException;

import model.dataccess.MaintainCustomerDataAccess;
import model.entities.*;

public class MaintainCustomerBusiness {
    private String customerID;

    // singleton implementation
    private static MaintainCustomerBusiness instance;
	private MaintainCustomerBusiness () {}
    public static MaintainCustomerBusiness getInstance() {
        return instance = instance == null ? new MaintainCustomerBusiness() : instance;
    }

    public Customer SearchCustomer() throws SQLException, ClassNotFoundException{
        if (customerID == null) return null;
        return MaintainCustomerDataAccess.getInstance().SearchCustomer(customerID);
    }

    /**
     * @return String return the customerID
     */
    public String getCustomerID() {
        return customerID;
    }

    /**
     * @param customerID the customerID to set
     */
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

}
