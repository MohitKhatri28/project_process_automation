package com.project_process_automation.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDao {
	public boolean validate(Login login) throws ClassNotFoundException, SQLException {
        boolean status = false;

        Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project_process_automation?useSSl=false","root","Messidona#3");
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery("SELECT * FROM login WHERE username = '" + login.getUsername() +"' and pswd = '"+ login.getPassword() +"';");
        status = rs.next();

        return status;
	}
}	

