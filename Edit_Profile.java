/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.DriverManager;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;

/**
 *
 * @author student
 */
@WebServlet(urlPatterns = {"/Edit_Profile"})
public class Edit_Profile extends HttpServlet {
    
    Connection conn;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        Statement stmt;
        
        //Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>\n" +
"<!--contactUs.html by Wayne O'Mahony -->\n" +
"\n" +
"<html>\n" +
"<head>\n" +
"	\n" +
"	<title>\n" +
"		Edit your Profile\n" +
"	</title>\n" +
"	\n" +
"	\n" +
"	\n" +
"	<link rel=\"stylesheet\" type=\"text/css\" href=\"index2.css\">\n" +
"	\n" +
"</head>\n" +
"\n" +
"<body>\n" +
"\n" +
"<div id=\"container\">\n" +
"\n" +
"<div id=\"banner\">\n" +
"\n" +
"		<br>\n" +
"		<a href=\"https://www.facebook.com/\" target=\"_blank\"><img class=\"socialmedia\" src=\"images/facebook.jpg\"></a>\n" +
"		<a href=\"https://www.twitter.com/\" target=\"_blank\"><img class=\"socialmedia\" src=\"images/twitter.jpg\"></a>\n" +
"		<a href=\"https://www.linkedin.com/\" target=\"_blank\"><img class=\"socialmedia\" src=\"images/linkedIn.jpg\"></a>\n" +
"		<a href=\"https://plus.google.com/\" target=\"_blank\"><img class=\"socialmedia\" src=\"images/googlePlus.jpg\"></a>\n" +
"		\n" +
"\n" +
"</div><!--Closing banner-->	\n" +
"\n" +
"<div id=\"top-menu\">\n" +
"<br>\n" +
"	<ul>\n" +
"		<li><a href=\"General_Information.html\">Home</a></li>\n" +
"		\n" +
"		<li><a href=\"Search_Apply.html\">Latest jobs</a></li>\n" +
"		<li><a href=\"Apply.html\">Applications</a></li>\n" +
"		<li><a href=\"Add_CV.html\">Add your CV</a></li>\n" +
"                <li><a href=\"Welcome_Login.html\">Log Out</a></li>\n" +
"	<ul>\n" +
"</div><!--Closing top-menu-->\n" +
"\n" +
"<div id=\"story\">\n" +
"\n" +
"	<img class=\"storyImage\" src=\"images/contactUs.jpg\" onmouseout=\"this.src='images/contactUs.jpg';\" onmouseover=\"this.src='images/contactUs1.jpg';\">\n" +
"	\n" +
"        <a href=\"Edit_Profile.html\">Edit your details</a>\n" +
"                <br>\n" +
"	\n" +
"                <a href=\"Edit_CV.html\">Edit your CV</a>\n" +
"                <br>\n" +
"        \n" +
"	<h2>\n" +
"		Edit your Profile here to optimise it!\n" +
"	</h2>");
        //String heading = "Edit CV";
        //String docType = "<!doctype html>";
        //out.println("<h4>" + heading + "</h4>");
        
        try
        {
            //Execute SQL query
            stmt = (Statement) conn.createStatement();
            String sql;
            sql = "SELECT first_name, last_name, mobile_number, email_address, password, expertise FROM users";
            ResultSet rs = stmt.executeQuery(sql);
            //Extract data from result set
            
            while(rs.next())
            {
                //Retrieve by column name
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String mobile_number = rs.getString("mobile_number");
                String email_address = rs.getString("email_address");
                String password = rs.getString("password");
                String expertise = rs.getString("expertise");
                //display values
                out.print("<form id=\"add_CV_form\" action=\"Update_Profile\" method=\"POST\">\n" +
"			First Name: <input type=\"text\" name=\"first_name\" value =" + first_name + ">\n" +
"            <br><br>\n" +
"			Last Name: <input type=\"text\" name=\"last_name\" value =" + last_name + ">\n" +
"            <br><br>\n" +
"			Mobile Number: <input type=\"text\" name=\"mobile_number\" value = " + mobile_number + ">\n" +
"            <br><br>\n" +
"                        Email Address: <input type=\"text\" name=\"email_address\" value = " + email_address + ">\n" +
"            <br><br>\n" +
"                        Password: <input type=\"text\" name=\"password\" value = " + password + ">\n" +
"            <br><br>\n" +
"                        Expertise: <input type=\"text\" name=\"expertise\" value = " + expertise + ">\n" +
"            <br><br><br><br>\n" +
"                        <input id=\"submitButton\" type=\"submit\" value=\"Update\"/>\n" +
"        </form>");
                out.print("<!--<p id=\"demo\">Need an inspirational quote?<button type=\"button\" onclick=\"quotes()\">Click here!</button></p>-->\n" +
"		\n" +
"	\n" +
"</div><!--Closing story-->\n" +
"\n" +
"<div id=\"about\">\n" +
"\n" +
"	<h2>Salary Guides</h2>\n" +
"	\n" +
"	<table>\n" +
"		<tr>\n" +
"			<td>Engineering/Development Manager</td><td>75000-85000</td>\n" +
"		</tr>\n" +
"		<tr>\n" +
"			<td>Technical Architect</td><td>75000-90000</td>\n" +
"		</tr>\n" +
"		<tr>\n" +
"			<td>Mainframe Developer</td><td>40000-50000</td>\n" +
"		</tr>\n" +
"		<tr>\n" +
"			<td>C/C++ Developer</td><td>35000-65000</td>\n" +
"		</tr>\n" +
"		<tr>\n" +
"			<td>Web Services Developer</td><td>35000-65000</td>\n" +
"		</tr>\n" +
"		<tr>\n" +
"			<td>Android/IOS Developer</td><td>35000-65000</td>\n" +
"		</tr>\n" +
"		<tr>\n" +
"			<td>Cold Fusion Developer</td><td>35000-65000</td>\n" +
"		</tr>\n" +
"		<tr>\n" +
"			<td>PHP Developer</td><td>35000-65000</td>\n" +
"		</tr>\n" +
"		<tr>\n" +
"			<td>Python Developer</td><td>35000-65000</td>\n" +
"		</tr>\n" +
"		<tr>\n" +
"			<td>SharePoint Developer</td><td>45000-70000</td>\n" +
"		</tr>\n" +
"		<tr>\n" +
"			<td>Art Director</td><td>75000-95000</td>\n" +
"		</tr>\n" +
"		<tr>\n" +
"			<td>Creative Manager</td><td>55000-70000</td>\n" +
"		</tr>\n" +
"		<tr>\n" +
"			<td>Interactive Designer</td><td>45000-60000</td>\n" +
"		</tr>\n" +
"		<tr>\n" +
"			<td>UI/UX Engineer</td><td>50000-65000</td>\n" +
"		</tr>\n" +
"		\n" +
"	</table>\n" +
"	\n" +
"	\n" +
"		\n" +
"</div><!--Closing about-->\n" +
"\n" +
"\n" +
"\n" +
"<div id=\"footer\">\n" +
"\n" +
"	<hr>\n" +
"\n" +
"	<ul>\n" +
"		<li> <a href=\"index2.html\">Home</a> </li>\n" +
"		<li> <a href=\"events.html\">Events</a> </li>\n" +
"		<li> <a href=\"latestJobs.html\">Latest jobs</a> </li>\n" +
"		<li> <a href=\"preparation.html\">Preparation</a> </li>\n" +
"		<li> <a href=\"contactUs.html\">Contact Us</a> </li>\n" +
"	<ul>\n" +
"	<br>\n" +
"	<br>\n" +
"	\n" +
"<div id=\"subfooter\">\n" +
"	\n" +
"		<p>\n" +
"		\n" +
"		CheckITJobs, Pallas upper, Borrisoleigh, Thurles, Co.Tipperary<br>\n" +
"		T:0504 51525 	M:087 7550454<br>\n" +
"		Email:wayne@checkitjobs.com<br>\n" +
"		Copyright &copy; Wayne O'Mahony 2013\n" +
"	\n" +
"		</p>\n" +
"		\n" +
"</div><!--Closing subfooter-->\n" +
"\n" +
"\n" +
"</div><!--Closing footer-->\n" +
"\n" +
"</div><!--Closing container-->\n" +
"\n" +
"</body>\n" +
"\n" +
"</html>\n" +
"\n" +
"<!--The above content was sourced from Vantage Recruitment and CPL recruitment-->\n" +
"\n" +
"");
                //response.sendRedirect("Search_Apply.html");
            }
            
            //out.println("</body></html>");
        }
        
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void init() throws ServletException
    {
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "recruitmentdb";
        String userName = "root";
        String password = "password";
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(url+dbName,userName,password);
        }
        
        catch(Exception e)
        {
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        /*Statement stmt;
        
        //Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String heading = "Current Jobs";
        //String docType = "<!doctype html>";
        out.println("<h4>" + heading + "</h4>");
        
        try
        {
            //Execute SQL query
            stmt = (Statement) conn.createStatement();
            String sql;
            sql = "SELECT title, company_name, location, salary, description FROM jobs";
            ResultSet rs = stmt.executeQuery(sql);
            //Extract data from result set
            
            while(rs.next())
            {
                //Retrieve by column name
                String title = rs.getString("title");
                String company_name = rs.getString("company_name");
                String location = rs.getString("location");
                String salary = rs.getString("salary");
                String description = rs.getString("description");
                //display values
                out.print("<table border=2 bgcolor=AAABBB><tr><td>");
                out.print("Job Title: " + title);
                out.print("<br>" +" Company Name: " + company_name);
                out.print("<br>" +" Location: " + location);
                out.print("<br>" +" Salary: " + salary);
                out.print("<br>" +" Description: " + description + "<br>");
                out.print("</td></tr></table>");
                out.print("<br><br>");
            }
            
            //out.println("</body></html>");
        }
        
        catch(Exception e)
        {
            e.printStackTrace();
        }*/
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
