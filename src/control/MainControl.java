package control;

import java.io.IOException;
import java.sql.SQLException;
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
        List<Activity> activities = MaintainActivityBusiness.getInstance().list();
        request.setAttribute("listCategory", activities);

	    RequestDispatcher rd = request.getRequestDispatcher("/view/MainView.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String address = "";
		
		try {
			String broncoID = request.getParameter("broncoid");
			MaintainCustomerBusiness mb = MaintainCustomerBusiness.getInstance();
		} catch (Exception e) {
			request.setAttribute("ErrorLogin", e.getMessage());
			address = "/view/LoginView.jsp";
		}
	    RequestDispatcher rd = request.getRequestDispatcher(address);
		rd.forward(request, response);

	}
	
}


