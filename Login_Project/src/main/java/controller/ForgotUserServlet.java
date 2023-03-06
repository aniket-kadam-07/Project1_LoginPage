package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ForgotUserService;

@WebServlet("/forgot_user_link")
public class ForgotUserServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//fetch data
		 String mail = req.getParameter("mail");
		 String password = req.getParameter("username");
		 
		 ForgotUserService f1 = new ForgotUserService();
		 
		 int count = f1.forgotUser(password, mail);
		 req.setAttribute("count", count);
		 RequestDispatcher rd = req.getRequestDispatcher("forgot_user.jsp");
		 rd.include(req, resp);
	}
}
