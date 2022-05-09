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

    public void create(Customer customer) throws Exception {
        if (customer.getBroncoID().strip().length() == 0) throw new MessageException("Bronco ID not informed");
        if (customer.getDiscount()<0) throw new MessageException("Discount cannot be negative");
        if (customer.getFirstName().strip().length() == 0) throw new MessageException("First name not informed");
        if (customer.getLastName().strip().length() == 0) throw new MessageException("Last name not informed");
        MaintainCustomerDataAccess.getInstance().create(customer);
    }

    public Customer search() throws Exception {
        if (broncoID == null) return null;
        Customer c = MaintainCustomerDataAccess.getInstance().search(broncoID);
        if (c==null) throw new MessageException("Customer not found");
        return c;
    }

    public void update(Customer customer) throws Exception {
        if (customer.getBroncoID()=="") throw new MessageException("Bronco ID not informed");
        if (customer.getDiscount()<0) throw new MessageException("Discount cannot be negative");
        if (customer.getFirstName().strip().length() == 0) throw new MessageException("First name not informed");
        if (customer.getLastName().strip().length() == 0) throw new MessageException("Last name not informed");
        MaintainCustomerDataAccess.getInstance().update(customer);
    }

    public void delete(Customer customer) throws Exception {
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
