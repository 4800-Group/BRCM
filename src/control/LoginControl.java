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
public class LoginControl extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
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
            RegisterVisitBusiness.getInstance().register(customer);
	        RegisterVisitBusiness.getInstance().register(customer);
	        List<Activity> activities = MaintainActivityBusiness.getInstance().list();
	        request.setAttribute("listCategory", activities);
			address = "/view/MainView.jsp";
            List<Visit> visits = customer.getVisits();
            Collections.sort(visits);
            Visit mostRecentVisit = visits.get(0);
            request.setAttribute("activities",RegisterActivityBusiness.getInstance().list(mostRecentVisit));
		} catch (Exception e) {
			request.setAttribute("ErrorLogin", e.getMessage());
			address = "/view/LoginView.jsp";
		}
	    RequestDispatcher rd = request.getRequestDispatcher(address);
		rd.forward(request, response);

	}
	
}

