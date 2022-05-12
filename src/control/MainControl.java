package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entities.*;
import model.business.*;

@SuppressWarnings("serial")
public class MainControl extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doPost(req, resp);

	    RequestDispatcher rd = request.getRequestDispatcher("/view/MainView.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String address = "";
		try {
			String broncoID = request.getParameter("broncoid");
			MaintainCustomerBusiness mb = MaintainCustomerBusiness.getInstance();
			mb.setBroncoID(broncoID);
			Customer customer = mb.search();
			request.setAttribute("Name", customer.getFirstName() + ' ' + customer.getLastName());
			request.setAttribute("broncoid", broncoID);
	        List<Activity> activities = MaintainActivityBusiness.getInstance().list();
	        request.setAttribute("listCategory", activities);
			address = "/view/MainView.jsp";
            String activityID = request.getParameter("selection");
            System.out.println(activityID);
            List<Visit> visits = customer.getVisits();
            Collections.sort(visits);
            Visit mostRecentVisit = visits.get(0);
            MaintainActivityBusiness mab = MaintainActivityBusiness.getInstance();
            try{
                mab.setActivityID(Integer.parseInt(activityID));
            }
            catch (Exception e){
                throw new MessageException("Invalid activity id");
            }
            Activity activity = mab.search();
            if (visits.size()==0) throw new MessageException("No visit recorded yet");
            RegisterActivityBusiness.getInstance().register(mostRecentVisit, activity);
            request.setAttribute("activities",RegisterActivityBusiness.getInstance().list(mostRecentVisit));
		} catch (Exception e) {
			request.setAttribute("ErrorLogin", e.getMessage());
		}
	    RequestDispatcher rd = request.getRequestDispatcher(address);
		rd.forward(request, response);

	}
	
}


