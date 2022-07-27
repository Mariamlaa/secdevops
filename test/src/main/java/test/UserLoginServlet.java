package test;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;
 
@WebServlet("/home")
public class UserLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public UserLoginServlet() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	
    	
        String email = request.getParameter("email");
        String password = request.getParameter("password");
         
        UserDAO userDao = new UserDAO();

        try {
        	
            User user = userDao.checkLogin(email, password);
            String destPage = null;
             
            if (user != null) {
            	HttpSession session = request.getSession();
            	
               	session.setAttribute("user", user);
               //	session.invalidate();
               	//request.getSession();

                destPage = "home.jsp";
          
            } 
            else {
                String message = "Invalid email/password";
                request.setAttribute("message", message); 
                destPage ="login.jsp";
               
            }
             
            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);
        }
        catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    	
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
         doGet(request,response); 

    }
}
    
  
    	

