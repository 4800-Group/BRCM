package model.business;
import java.sql.SQLException;

import model.dataccess.MaintainActivityDataAccess;
import model.entities.*;

public class MaintainActivityBusiness {
    private int activityID;

    // singleton implementation
    private static MaintainActivityBusiness instance;
	private MaintainActivityBusiness () {}
    public static MaintainActivityBusiness getInstance() {
        return instance = instance == null ? new MaintainActivityBusiness() : instance;
    }

    public void create(Activity activity) throws SQLException {
        // rules
        MaintainActivityDataAccess.getInstance().create(activity);
    }

    public Activity search() throws SQLException {
        return MaintainActivityDataAccess.getInstance().search(activityID);
    }

    public void update(Activity activity) throws SQLException {
        // rules
        MaintainActivityBusiness.getInstance().update(activity);
    }

    public void delete(Activity activity) throws SQLException {
        MaintainActivityBusiness.getInstance().delete(activity);
    }

    

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

}
