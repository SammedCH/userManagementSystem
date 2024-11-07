package userManagementSystem.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApprovalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestId = request.getParameter("request_id");
        String action = request.getParameter("action"); // Either 'approve' or 'reject'

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_access_management", "root", "password");

            String status = "approve".equals(action) ? "Approved" : "Rejected";
            String query = "UPDATE requests SET status=? WHERE id=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, status);
            pstmt.setString(2, requestId);
            pstmt.executeUpdate();
            
            response.sendRedirect("pendingRequests.jsp?success=Request Updated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

