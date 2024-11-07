package userManagementSystem.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RequestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String software = request.getParameter("software");
        String accessType = request.getParameter("access_type");
        String reason = request.getParameter("reason");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_access_management", "root", "password");

            String query = "INSERT INTO requests (user_id, software_id, access_type, reason, status) VALUES ((SELECT id FROM users WHERE username=?), (SELECT id FROM software WHERE name=?), ?, ?, 'Pending')";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, software);
            pstmt.setString(3, accessType);
            pstmt.setString(4, reason);
            pstmt.executeUpdate();
            
            response.sendRedirect("requestAccess.jsp?success=Request Submitted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

