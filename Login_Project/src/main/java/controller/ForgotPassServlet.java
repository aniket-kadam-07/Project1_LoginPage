package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ForgotPasswordService;

@WebServlet("/forgot_pass_link")
public class ForgotPassServlet extends HttpServlet {
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//fetch data
		 String mail = req.getParameter("mail");
		 String password = req.getParameter("password");
		 
		 ForgotPasswordService f1 = new ForgotPasswordService();
		 
		 int count = f1.forgotPass(password, mail);
		 
		 req.setAttribute("count", count);
		 RequestDispatcher rd = req.getRequestDispatcher("forgot_pass.jsp");
		 rd.include(req, resp);
		 
	}
}
