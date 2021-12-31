<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%
try{
String cemail= request.getParameter("email");
String pass= request.getParameter("password");
Class.forName("com.mysql.jdbc.Driver");
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gift","root","poppy#558");
PreparedStatement ps=conn.prepareStatement("select cemail,pass from mytable where cemail=? and pass=?");
ps.setString(1,cemail);
ps.setString(2,pass);
ResultSet rs=ps.executeQuery();
while(rs.next()){
try{

response.sendRedirect("gifts.html");
}
catch(Exception e)
{
    out.println(e);
}
}
ps.close();
conn.close();
}
catch(Exception e)
{
    out.println(e);
}
%>