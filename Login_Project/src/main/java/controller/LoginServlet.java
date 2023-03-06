package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LoginServiceLayer;

@WebServlet("/login_link")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//fetch data
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String login = req.getParameter("login");
		String createAcc = req.getParameter("create_account");
		String forgotPass = req.getParameter("forgot_password");
		String forgotUser = req.getParameter("forgot_username");
		
		if(login!=null) {
			LoginServiceLayer l1 = new LoginServiceLayer();
			
			boolean status = l1.verify(username, password);
			
			req.setAttribute("status", status);
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.include(req, resp);
		}else if(createAcc!=null) {
			resp.sendRedirect("createAccount.html");
		}else if(forgotPass!=null) {
			resp.sendRedirect("forgot_password.html");
		}else if(forgotUser!=null){
			resp.sendRedirect("forgot_username.html");
		}
	}
}
