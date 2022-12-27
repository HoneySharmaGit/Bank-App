package org.pentagonspace.homeApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;
public class LoginPage extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
	ServletException, IOException{
		String email=req.getParameter("em");
		String password=req.getParameter("pw");
		
		/** connect to JDBC */
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from pentagonspace.user where email=? AND password=?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&"
					+ "password=dinga");
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,email);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			PrintWriter out=resp.getWriter();
			if(rs.next()) {
				String uname=rs.getString("name");
				int ubalance=rs.getInt("balance");
				out.println("<html>\r\n" + 
						"\r\n" + 
						"<head>\r\n" + 
						"    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet integrity sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\" crossorigin=\"anonymous\">\r\n" + 
						"    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n" + 
						"    <title>Login</title>\r\n" + 
						"    <style>\r\n" + 
						"        body {\r\n" + 
						"            background-color: #4aed6a;\r\n" + 
						"        }\r\n" + 
						"\r\n" + 
						"        .btn-primary {\r\n" + 
						"            background-color: blue;\r\n" + 
						"            font-size: 16px;\r\n" + 
						"            padding-top: 2px;\r\n" + 
						"            padding-bottom: 2px;\r\n" + 
						"            width: 150px;\r\n" + 
						"        }\r\n" + 
						"\r\n" + 
						"        .footer {\r\n" + 
						"            position: fixed;\r\n" + 
						"            bottom: 5px;\r\n" + 
						"            width: 100%;\r\n" + 
						"        }\r\n" + 
						"\r\n" + 
						"        div.main {\r\n" + 
						"            border: solid 1px black;\r\n" + 
						"            margin: 5%;\r\n" + 
						"            height: 240px;\r\n" + 
						"            background-color: #f0f0eb;\r\n" + 
						"            position: fixed;\r\n" + 
						"            width: 90%;\r\n" + 
						"            padding: 25px;\r\n" + 
						"            border-radius: 5px;\r\n" + 
						"            box-shadow: 10px 10px 10px -9px black;\r\n" + 
						"        }\r\n" + 
						"    </style>\r\n" + 
						"</head>\r\n" + 
						"\r\n" + 
						"<body>\r\n" + 
						"    <center>\r\n" + 
						"        <div class=\"main\">\r\n" + 
						"            <h1>"+uname+" Welcome your Balance is "+ubalance+"Rs.</h1>"
						+ "<br><a href=\"AddMoney.html\"><button class=\"btn btn-primary\" type=\"submit\" style=\"background"
						+ "-color:green;\">Add Money</button></a> &nbsp &nbsp <a href=\"WithdrawMoney.html\"><button class=\"btn btn-primary\" "
						+ "type=\"submit\" style=\"background-color:green;\">Withdraw Money</button></a><br><br>"
						+ "<a href=\"Login.html\"><button class=\"btn btn-primary\" type=\"submit\">Logout</button>"
						+ "</a></div>\r\n" + 
						"        <div class=\"footer\">\r\n" + 
						"            <p>&copycopyright-2022 all right reserved.\r\n" + 
						"                <html>\r\n" + 
						"        </div>\r\n" + 
						"    </center>\r\n" + 
						"</body>\r\n" + 
						"\r\n" + 
						"</html>");
				
				/* <br><br><html><body bgcolor=pink><center><h1>"+uname+" Welcome to Application."
						+"</h1><br><a href=\"Login.html\">Logout</a></center></body></html> */
			}
			else {
				out.println("<html>\r\n" + 
						"\r\n" + 
						"<head>\r\n" + 
						"    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\" crossorigin=\"anonymous\">\r\n" + 
						"    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n" + 
						"    <title>Registeration</title>\r\n" + 
						"    <style>\r\n" + 
						"        body {\r\n" + 
						"            background-color: #d45765;\r\n" + 
						"        }\r\n" + 
						"\r\n" + 
						"        .btn-primary {\r\n" + 
						"            background-color: blue;\r\n" + 
						"            font-size: 16px;\r\n" + 
						"            padding-top: 2px;\r\n" + 
						"            padding-bottom: 2px;\r\n" + 
						"            width: 150px;\r\n" + 
						"        }\r\n" + 
						"\r\n" + 
						"        .footer {\r\n" + 
						"            position: fixed;\r\n" + 
						"            bottom: 5px;\r\n" + 
						"            width: 100%;\r\n" + 
						"        }\r\n" + 
						"\r\n" + 
						"        div.main {\r\n" + 
						"            border: solid 1px black;\r\n" + 
						"            margin: 5%;\r\n" + 
						"            height: 33%;\r\n" + 
						"            background-color: #f0f0eb;\r\n" + 
						"            position: fixed;\r\n" + 
						"            width: 90%;\r\n" + 
						"            padding: 25px;\r\n" + 
						"            box-shadow: 10px 10px 10px -9px black;\r\n" + 
						"            border-radius: 5px;\r\n" + 
						"        }\r\n" + 
						"    </style>\r\n" + 
						"</head>\r\n" + 
						"\r\n" + 
						"<body>\r\n" + 
						"    <center>\r\n" + 
						"        <div class=\"main\">\r\n" + 
						"            <h1>Invalid Email and Password.</h1>\r\n" + 
						"            <h6>[no data found in database.]</h6><br><a href=\"Login.html\">"
						+ "<button class=\"btn btn-primary\" type=\"submit\">back</button></a></div>\r\n" + 
						"        <div class=\"footer\">\r\n" + 
						"            <p>&copycopyright-2022 all right reserved.</p>\r\n" + 
						"        </div>\r\n" + 
						"    </center>\r\n" + 
						"</body>\r\n" + 
						"\r\n" + 
						"</html>");
			
			/* <br><br><html><body bgcolor=pink><center><h1>invalid username and"
						+ " password!</h1><br><a href=\"Login.html\">Logout</a></center></body></html> */
			
			}
			
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
