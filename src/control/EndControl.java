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
public class EndControl extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        String address = "/view/LoginView.jsp";
	    RequestDispatcher rd = request.getRequestDispatcher(address);
		rd.forward(request, response);
	}
}
