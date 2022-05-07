package model.business;
import java.sql.SQLException;

import model.dataccess.MaintainActivityDataAccess;
import model.dataccess.MaintainCustomerDataAccess;
import model.dataccess.RegisterVisitDataAccess;
import model.entities.*;

public class RegisterVisitBusiness {
    // singleton implementation
    private static RegisterVisitBusiness instance;
	private RegisterVisitBusiness () {}
    public static RegisterVisitBusiness getInstance() {
        return instance = instance == null ? new RegisterVisitBusiness() : instance;
    }

    public void register(Customer customer) throws SQLException{
        Visit visit = new Visit(customer);
        RegisterVisitDataAccess.getInstance().register(visit);
    }
}
