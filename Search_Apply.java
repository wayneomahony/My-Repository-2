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
@WebServlet(urlPatterns = {"/Search_Apply"})
public class Search_Apply extends HttpServlet {
    
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
"<!--latestJobs.html by Wayne O'Mahony -->\n" +
"\n" +
"<html>\n" +
"<head>\n" +
"	\n" +
"	<title>\n" +
"		Search Jobs\n" +
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
"	<img class=\"storyImage\" src=\"images/jobs.jpg\" onmouseout=\"this.src='images/jobs.jpg';\" onmouseover=\"this.src='images/jobs1.jpg';\">\n" +
"        \n" +
"        <a href=\"Edit_Profile.html\">Edit your details</a>\n" +
"                <br>\n" +
"	\n" +
"                <a href=\"Edit_CV.html\">Edit your CV</a>\n" +
"                <br>\n" +
"        \n" +
"	<h2>\n" +
"		Latest Jobs\n" +
"	</h2>\n" +
"	\n" +
"	<h3>Click below to get a list of the newest jobs being advertised \n" +
"	exclusively here on CheckITJobs. You can only apply for \n" +
"	these jobs through our service, ensuring our clients \n" +
"	get to interview the best possible candidates for any \n" +
"	positions available. </h3>");
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
                out.print("<b>Job Title:</b> " + title);
                out.print("<br>" +" <b>Company Name:</b> " + company_name);
                out.print("<br>" +" <b>Location:</b> " + location);
                out.print("<br>" +" <b>Salary:</b> " + salary);
                out.print("<br>" +" <b>Description:</b> " + description + "<br>");
                out.print("</td></tr></table>");
                out.print("\n" +
"	\n" +
"		\n" +
"	\n" +
"</div><!--Closing story-->\n" +
"\n" +
"<div id=\"about\">\n" +
"\n" +
"	<h2>Job of the Week</h2>\n" +
"	\n" +
"	<h3>Technical Lead - Dublin City Centre(Job#8071)</h3>\n" +
"	\n" +
"	<p>A global financial services company with significant operations\n" +
"	in Dublin has a hiring needs for a Technical Lead.<br><br>\n" +
"\n" +
"The project will establish a Data Integration Hub with all Data \n" +
"consolidated within a central DB2 database. There are 2 ways of \n" +
"accepting data – Batch File and Web Service (SOA). The main technologies\n" +
" are IBM InfoSphere, specifically DataStage for the batch processing\n" +
" and then a set of web services deployed on WebSphere Application Server.<br><br>\n" +
"\n" +
"You will be working closely with senior management to ensure you \n" +
"deliver the correct end solution.<br><br>\n" +
"\n" +
"This is a 6 month daily rate contract.<br><br>\n" +
"\n" +
"\n" +
"What you need\n" +
"Skills required:\n" +
"<br>\n" +
"DataStage<br>\n" +
"DB2<br>\n" +
"SOA - Web Services<br>\n" +
"Websphere Application Server<br>\n" +
"XML<br><br>\n" +
"\n" +
"\n" +
"</p>\n" +
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
