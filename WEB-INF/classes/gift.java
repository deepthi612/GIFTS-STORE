import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class gift extends HttpServlet{
public void doPost(HttpServletRequest request,HttpServletResponse response)
throws ServletException,IOException
{
response.setContentType("text/html");
PrintWriter out=response.getWriter();

String cemail = request.getParameter("email");
String pass= request.getParameter("password");
String cpass= request.getParameter("cpassword");

try{
Class.forName("com.mysql.jdbc.Driver");
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gift","root","poppy#558");
PreparedStatement ps=conn.prepareStatement("insert into mytable values(?,?,?)");
ps.setString(1,cemail);
ps.setString(2,pass);
ps.setString(3,cpass);
ps.executeUpdate();
out.println("Record inserted successfully");
ps.close();
conn.close();
}catch(Exception e)
{
out.println(e);
}
}
}
