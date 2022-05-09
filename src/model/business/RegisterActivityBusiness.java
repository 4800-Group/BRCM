package model.business;
import java.sql.SQLException;
import java.util.List;

import model.dataccess.MaintainActivityDataAccess;
import model.dataccess.MaintainCustomerDataAccess;
import model.dataccess.RegisterActivityDataAccess;
import model.dataccess.RegisterVisitDataAccess;
import model.entities.*;

public class RegisterActivityBusiness {
    // singleton implementation
    private static RegisterActivityBusiness instance;
	private RegisterActivityBusiness () {}
    public static RegisterActivityBusiness getInstance() {
        return instance = instance == null ? new RegisterActivityBusiness() : instance;
    }

    public void register(Visit visit, Activity activity) throws SQLException{
        VisitActivity va = new VisitActivity(visit, activity);
        RegisterActivityDataAccess.getInstance().register(va);
    }

    public List<VisitActivity> list(Visit visit) throws SQLException{
        return RegisterActivityDataAccess.getInstance().list(visit);
    }
}
