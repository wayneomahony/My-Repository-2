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
import java.sql.ResultSet;

/**
 *
 * @author Wayne
 */
@WebServlet(name = "Confirm_Login", urlPatterns = {"/Confirm_Login"})
public class Confirm_Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    //variables here
    String DBemail_address;
    String DBpassword;
    String Screenemail_address;
    String Screenpassword;
    
    Connection conn;
    PreparedStatement prepStat;
    Statement stat;
    
    public void init() throws ServletException
    {
        /*String url = "jdbc:mysql://localhost:3306/";
        String dbName = "recruitmentdb";
        String userName = "root";
        String password = "password";
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection
        (url+dbName,userName,password);
            stat = (Statement) conn.createStatement();
            String query = "SELECT email_address, password FROM users";
            stat.executeQuery(query);
            ResultSet rs = stat.getResultSet();
            
            while(rs.next())
            {
                DBemail_address = rs.getString("email_address");
                DBpassword = rs.getString("password");
                
                if(DBemail_address.equals("email_address")&&DBpassword.equals("password"))
                {
                    try{response.sendRedirect("Welcome_Login.html");}
                    catch(Exception e){}
                }
            }
        }
        
        catch(Exception e)
        {
            
        }*/
    } // end of init method
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
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
            String query = "SELECT email_address, password FROM users";
            stat.executeQuery(query);
            ResultSet rs = stat.getResultSet();
            Screenemail_address = request.getParameter("email_address");
            Screenpassword = request.getParameter("password");
        
        while(rs.next())
            {
                DBemail_address = rs.getString("email_address");
                DBpassword = rs.getString("password");
                
                if(DBemail_address.equals(Screenemail_address) && DBpassword.equals(Screenpassword))
                {
                    try
                    {
                        response.sendRedirect("Login_Success.html");
                    }
                    
                    catch(Exception e)
                    {
                    
                    }
                }
                else
                {
                    response.sendRedirect("Welcome_Login_Bad.html");
                }
                    
            }
            }
        
        catch(Exception e){}
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
