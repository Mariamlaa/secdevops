package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mod")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyServlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("Action").equals("Add User")) {
		      PrintWriter printWriter = response.getWriter();
		      User user = new User();
		      ModUserDAO dao = new ModUserDAO();
		      user.setFullname(request.getParameter("fullname"));
		      user.setEmail(request.getParameter("email"));
		      user.setPassword(request.getParameter("password"));
		      user.setRef((request.getParameter("ref")));

			  boolean result = false;
			try {
				result = dao.addUser(user);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  System.out.println(result);
			  RequestDispatcher dispatcher = request.getRequestDispatcher("addUser.jsp");
		      dispatcher.include(request, response);
		      printWriter.print("<br><h2>User added Successfully!!</h2>");		
		}
		
		if (request.getParameter("Action").equals("Edit")) {
			
		      PrintWriter printWriter = response.getWriter();
		      User user = new User();
		      ModUserDAO dao = new ModUserDAO();
		      user.setFullname(request.getParameter("fullname"));
		      user.setEmail(request.getParameter("email"));
		      user.setPassword(request.getParameter("password"));
		      user.setRef(request.getParameter("ref"));
		      
		      boolean result =false;
			try {
				result = dao.editUser(user);

			} catch (ClassNotFoundException | SQLException e) {				
				e.printStackTrace();
			}
			  System.out.println(result);
		      RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
		      dispatcher.include(request, response);
		      printWriter.print("<br><h2>User Edited Successfully!!</h2>");
		    }
	}

}
