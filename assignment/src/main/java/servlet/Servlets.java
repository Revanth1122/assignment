package servlet;
import model.UserDetail;
import java.io.IOException;
import dao.LoginDAO;
import dao.LoginDAOImpl;
import exceptions.UserNotFoundException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/customer")
public class Servlets extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String given_user = req.getParameter("username");
		String given_pass = req.getParameter("username");
		UserDetail user=new UserDetail();
		user.setUserName(given_user);
		user.setPassword(given_pass);
		LoginDAO status=new LoginDAOImpl();
		try {
			System.out.println(status.getUserDetailsByUserName(given_user));
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
        RequestDispatcher dispatcher =  req.getRequestDispatcher("customer.jsp");
        dispatcher.forward(req, resp);

    }

}
