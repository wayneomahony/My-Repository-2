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
@WebServlet(name = "Update_CV", urlPatterns = {"/Update_CV"})
public class Update_CV extends HttpServlet {

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
    String job1_title;
    String years_worked1;
    String job1_salary;
    String job2_title;
    String years_worked2;
    String job2_salary;
    
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
            stat.execute("SELECT * FROM resumes");
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
        job1_title = request.getParameter("job1_title");
        years_worked1 = request.getParameter("years_worked1");
        job1_salary = request.getParameter("job1_salary");
        job2_title = request.getParameter("job2_title");
        years_worked2 = request.getParameter("years_worked2");
        job2_salary = request.getParameter("job2_salary");
        
        try
        {
            String query = "UPDATE resumes SET first_name = ?, last_name = ?, mobile_number = ?, email_address = ?, job1_title = ?, years_worked1 = ?, job1_salary = ?, job2_title = ?, years_worked2 = ?, job2_salary = ? WHERE 1=1";
            prepStat = (PreparedStatement) conn.prepareStatement(query);
            prepStat.setString(1, first_name);
            prepStat.setString(2, last_name);
            prepStat.setString(3, mobile_number);
            prepStat.setString(4, email_address);
            prepStat.setString(5, job1_title);
            prepStat.setString(6, years_worked1);
            prepStat.setString(7, job1_salary);
            prepStat.setString(8, job2_title);
            prepStat.setString(9, years_worked2);
            prepStat.setString(10, job2_salary);
            prepStat.executeUpdate();
            response.sendRedirect("CV_Success.html");
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
