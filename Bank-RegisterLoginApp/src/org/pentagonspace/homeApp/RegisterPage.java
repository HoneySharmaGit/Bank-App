package org.pentagonspace.homeApp;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class RegisterPage extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
	ServletException, IOException{
		String name=req.getParameter("nm");
		String email=req.getParameter("em");
		String password=req.getParameter("pw");
		String atmpin=req.getParameter("pin");
		int atm=Integer.parseInt(atmpin);
		
		PrintWriter out=resp.getWriter();
		out.println("<html>\r\n" + 
				"\r\n" + 
				"<head>\r\n" + 
				"    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\" crossorigin=\"anonymous\">\r\n" + 
				"    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n" + 
				"    <title>Registeration</title>\r\n" + 
				"    <style>\r\n" + 
				"        body {\r\n" + 
				"            background-image: url(\"coding-image.jpg\");\r\n" + 
				"            background-repeat: no-repeat;\r\n" + 
				"            background-attachment: fixed;\r\n" + 
				"            background-size: 100% 100%;\r\n" + 
				"        }\r\n" + 
				"\r\n" + 
				"        .btn-success {\r\n" + 
				"            background-color: green;\r\n" + 
				"            font-size: 16px;\r\n" + 
				"            padding-top: 2px;\r\n" + 
				"            padding-bottom: 2px;\r\n" + 
				"        }\r\n" + 
				"\r\n" + 
				"        .footer {\r\n" + 
				"           position: fixed;\r\n" + 
				"            bottom: 0px;\r\n" + 
				"            height: 20px;\r\n" + 
				"            width: 100%;\r\n" + 
				"            background-color: grey;\r\n" + 
				"        }\r\n" + 
				"\r\n" + 
				"        div.main {\r\n" + 
				"            border: solid 1px grey;\r\n" + 
				"            border-radius: 5px;\r\n" + 
				"            margin: 3%;\r\n" + 
				"            height: 225px;\r\n" + 
				"            width: 935px;\r\n" + 
				"            background-color: #f0f0eb;\r\n" + 
				"            padding: 1.7%;\r\n" + 
				"            box-shadow: 10px 10px 10px -9px black;\r\n" + 
				"        }\r\n" + 
				"    </style>\r\n" + 
				"</head>\r\n" + 
				"\r\n" + 
				"<body>\r\n" + 
				"    <center>\r\n" + 
				"        <div class=\"main\">\r\n" + 
				"            <h1><big>"+name+"</big> Registration Completed for Bank</h1>---[ATM pin set Successfully.]---<br>\r\n" + 
				"            <h4>( go to Login Page)</h4><a href=\"Login.html\"><button class=\"btn btn-success\" type=\"submit\">back</button></a></div>\r\n" + 
				"        <div class=\"footer\">\r\n" + 
				"            <p>&copycopyright-2022 all right reserved.</p>\r\n" + 
				"        </div>\r\n" + 
				"    </center>\r\n" + 
				"</body>\r\n" + 
				"\r\n" + 
				"</html>"); 
		
		/* out.println("<html><head><link href=\"https://cdn.jsdelivr.net/npm/bootstrap"
				+ "@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity="
				+ "\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9"
				+ "CUG65\" crossorigin=\"anonymous\"><link rel=\"stylesheet\" href=\"htt"
				+ "ps://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min."
				+ "css\"><title>Registeration Successful</title><style>body{backgrou"
				+ "nd-color: #d9d9d4; }.btn-primary{background-color: blue;font-size: "
				+ "16px;padding-top:2px;padding-bottom: 2px;}.footer{position: fixed; "
				+ " bottom: 5px;width: 100%;}div.main{border: solid 1px grey;margin: "
				+ "5%;height: 31.3%;background-color: #f0f0eb;position: fixed;width:"
				+ " 90%;padding: 25px;}</style></head><body><center><div "
				+ "class=\"main\"><h1>"+name+" Registration Completed for Bank</h1>" 
				+ "<h4>( go to Login Page )</h4><a href=\"Login.html\"><button"
				+ " class=\"btn btn-primary\" type=\"submit\">back</button></a>"
				+ "</div><div class=\"footer\"><p>&copycopyright-2022 all right "
				+ "reserved.</p></div></center></body></html>");  */
		
		/* <html><body bgcolor=pink><center><h1>"+name+" Registration Completed for Bank</h1><br>"
		+ "<a href=\"Login.html\">back</a><small> to Login page</small></center></body></html> */
		
		out.flush();
		out.close();
		
		/** JDBC code to insert the data in database. */
		
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="insert into pentagonspace.user values(?,?,?,?,0)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&"
					+ "password=dinga");
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, password);
			pstmt.setInt(4, atm);
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
