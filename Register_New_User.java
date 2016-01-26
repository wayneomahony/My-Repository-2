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
import java.sql.SQLException;

/**
 *
 * @author Wayne
 */
@WebServlet(name = "Register_New_User", urlPatterns = {"/Register_New_User"})
public class Register_New_User extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    String first_name;
    String last_name;
    String mobile_number;
    String email_address;
    String password;
    String expertise;
    
    Connection conn;
    PreparedStatement prepStat;
    Statement stat;
    
    public void init() throws ServletException
    {
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "recruitmentdb";
        String userName = "root";
        String password = "password";
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection
        (url+dbName,userName,password);
            stat = (Statement) conn.createStatement();
            stat.execute("CREATE TABLE IF NOT EXISTS users "
            + "(first_name CHAR(20), last_name CHAR(20), mobile_number VARCHAR(10), email_address VARCHAR(40), password VARCHAR(20), expertise CHAR(20))");
        }
        
        catch(Exception e)
        {
            
        }
    } // end of init method
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        first_name = request.getParameter("first_name");
        last_name = request.getParameter("last_name");
        mobile_number = request.getParameter("mobile_number");
        email_address = request.getParameter("email_address");
        password = request.getParameter("password");
        expertise = request.getParameter("expertise");
        
        try
        {
            String query = "INSERT INTO users VALUES (?,?,?,?,?,?)";
            prepStat = (PreparedStatement) conn.prepareStatement(query);
            prepStat.setString(1, first_name);
            prepStat.setString(2, last_name);
            prepStat.setString(3, mobile_number);
            prepStat.setString(4, email_address);
            prepStat.setString(5, password);
            prepStat.setString(6, expertise);
            prepStat.executeUpdate();
            response.sendRedirect("Registration_Success.html");
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
            throws ServletException, IOException 
    {
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
            throws ServletException, IOException {
       //response.sendRedirect("Welcome_Login.html");
        processRequest(request, response);
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
