package test;

import java.sql.*;

public class ModUserDAO {
	
	public boolean addUser(User user) throws ClassNotFoundException, SQLException {
		
		String jdbcURL = "jdbc:mysql://localhost:3306/auth";
        String dbUser = "root";
        String dbPassword = "root";
 
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
        
        String sql = "INSERT INTO users (fullname,email,password,ref) VALUES (?,?,?,?)";
        int i = 0;
        try {
        	
        	PreparedStatement statement = connection.prepareStatement(sql);
        	statement.setString(1, user.getFullname());
        	statement.setString(2, user.getEmail());
        	statement.setString(3, user.getPassword());
        	statement.setString(4, user.getRef());
        	i = statement.executeUpdate();
        } 
        
        catch (SQLException e) {
            e.printStackTrace();
          }
        
        if(i==0) { return false;}
        else {return true;}
        	
        	
        }
	
	public boolean editUser(User user) throws ClassNotFoundException, SQLException{
        
		String jdbcURL = "jdbc:mysql://localhost:3306/auth";
        String dbUser = "root";
        String dbPassword = "root";
 
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
        String sql = "UPDATE users SET fullname=?, email=?, password=? WHERE ref=? ";
        int i = 0;
        try {
        	PreparedStatement statement = connection.prepareStatement(sql);
        	statement.setString(1, user.getFullname());
        	statement.setString(2, user.getEmail());
        	statement.setString(3, user.getPassword());
        	statement.setString(4, user.getRef());
        	i = statement.executeUpdate();
        }
        
        catch (SQLException e) {
            e.printStackTrace();
          }
        
        if(i==0) { return false;}
        else {return true;}
  	
	}
	

}
