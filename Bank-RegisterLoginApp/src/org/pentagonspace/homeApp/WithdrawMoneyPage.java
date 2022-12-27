package org.pentagonspace.homeApp;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;
public class WithdrawMoneyPage extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
	ServletException, IOException {
		String email=req.getParameter("em");
		String password=req.getParameter("pw");
		String amount=req.getParameter("am");
		int amt=Integer.parseInt(amount);
		String atmnum=req.getParameter("atm");
		int atmm=Integer.parseInt(atmnum);
		
		PrintWriter out=resp.getWriter();
		out.println("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"    <meta charset= \"utf-8\">\r\n" + 
				"    <meta name= \"viewport\" content= \"width=device-width, initial-scale=1\">\r\n" + 
				"    <link rel= \"stylesheet\" href= \"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n" + 
				"    <title>Withdraw Money Page</title>\r\n" + 
				"    <style>\r\n" + 
				"        body {\r\n" + 
				"            background-image: url(\"coding-image.jpg\");\r\n" + 
				"            background-repeat: no-repeat;\r\n" + 
				"            background-attachment: fixed;\r\n" + 
				"            background-size: 100% 100%;\r\n" + 
				"            \r\n" + 
				"        }\r\n" + 
				"\r\n" + 
				"        .btn-primary {\r\n" + 
				"            background-color: blue;\r\n" + 
				"            width: 392px;\r\n" + 
				"            font-size: 16px;\r\n" + 
				"        \r\n" + 
				"        }\r\n" + 
				"\r\n" + 
				"        .footer {\r\n" + 
				"            position: fixed;\r\n" + 
				"            bottom: 0px;\r\n" + 
				"            height: 20px;\r\n" + 
				"            width: 100%;\r\n" + 
				"            background-color: grey;\r\n" + 
				"        }\r\n" + 
				"\r\n" + 
				"        div.main {\r\n" + 
				"            border: solid 1px grey;\r\n" + 
				"            border-radius: 5px;\r\n" + 
				"            margin: 54px;\r\n" + 
				"            height: 205px;\r\n" + 
				"            width: 935px;\r\n" + 
				"            background-color: #f0f0eb;\r\n" + 
				"            padding: 1.7%;\r\n" + 
				"            box-shadow: 10px 10px 10px -9px black;\r\n" + 
				"            \r\n" + 
				"        }\r\n" + 
				"\r\n" + 
				"    </style>\r\n" + 
				"</head>\r\n" + 
				"\r\n" + 
				"<body>\r\n" + 
				"    <center>\r\n" + 
				"            <div class= \"main\">\r\n" + 
				"                <h1>Amount "+amt+"Rs. withdrawn Successfully.</h1>\r\n" + 
				"                <h4>( go to Login Page)</h4><a href=\"Login.html\"><button class=\"btn btn-success\" type=\"submit\">back</button></a> </div>\r\n" + 
				"        <div class= \"footer\">\r\n" + 
				"            <p>&copycopyright-2022 all right reserved.</p>\r\n" + 
				"        </div>\r\n" + 
				"    </center>\r\n" + 
				"</body>\r\n" + 
				"\r\n" + 
				"</html>");
		out.flush();
		out.close();
		
		/** JDBC code to insert the data in database. */
		
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="update pentagonspace.user set balance=balance-? where email=? and password=? and atm_number=?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=dinga");
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, amt);
			pstmt.setString(2, email);
			pstmt.setString(3, password);
			pstmt.setInt(4, atmm);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
