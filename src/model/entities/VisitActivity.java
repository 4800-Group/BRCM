
package model.entities;
import java.util.Date;
import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Entity
@Table(name="visit_activity")
public class VisitActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="visit_activity_id")
    private int VisitActivityID;

	@Column(name="time")
    private Timestamp time;
    
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name="visit_id")
    private Visit visit;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name="activity_id")
    private Activity activity;

    public VisitActivity() {}

    public VisitActivity(Visit visit, Activity activity) {
        this.visit = visit;
        this.activity = activity;
        time = new Timestamp(new Date().getTime());
    }

    /**
     * @param time the time to set
     */
    public void setTime(Timestamp time) {
        this.time = time;
    }

    /**
     * @return Visit return the visit
     */
    public Visit getVisit() {
        return visit;
    }

    /**
     * @param visit the visit to set
     */
    public void setVisit(Visit visit) {
        this.visit = visit;
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



