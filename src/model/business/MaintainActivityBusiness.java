package model.business;
import java.sql.SQLException;
import java.util.List;

import model.dataccess.MaintainActivityDataAccess;
import model.dataccess.MaintainPriceDataAccess;
import model.entities.*;

public class MaintainActivityBusiness {
    private int activityID;

    // singleton implementation
    private static MaintainActivityBusiness instance;
	private MaintainActivityBusiness () {}
    public static MaintainActivityBusiness getInstance() {
        return instance = instance == null ? new MaintainActivityBusiness() : instance;
    }

    public void create(Activity activity) throws Exception{
        if (activity.getCurrentPrice() < 0) throw new MessageException("Negative price not allowed");
        if (activity.getName().length() == 0) throw new MessageException("Activity name cannot be empty");
        MaintainActivityDataAccess.getInstance().create(activity);
    }

    public Activity search() throws Exception {
        Activity a = MaintainActivityDataAccess.getInstance().search(activityID);
        if (a==null) throw new MessageException("Activity ID invalid");
        return a;
    }

    public void update(Activity activity) throws Exception {
        if (activity.getCurrentPrice() < 0) throw new MessageException("Negative price not allowed");
        if (activity.getName().length() == 0) throw new MessageException("Activity name cannot be empty");
        MaintainActivityDataAccess.getInstance().update(activity);
    }

    public void delete(Activity activity) throws Exception {
        MaintainActivityDataAccess.getInstance().delete(activity);
    }

    public List<Activity> list() throws SQLException {
        return MaintainActivityDataAccess.getInstance().list();
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
