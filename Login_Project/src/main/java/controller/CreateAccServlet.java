package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CreateAccService;

@WebServlet("/createlink")
public class CreateAccServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//fetch data
		String mail = req.getParameter("mail");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		CreateAccService c1 = new CreateAccService();
		
		int count =c1.createAcc(username, password, mail);
		req.setAttribute("count", count);
		RequestDispatcher rd = req.getRequestDispatcher("createAccount.jsp");
		rd.include(req, resp);
		
	}
}
