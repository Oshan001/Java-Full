package com.example;
//import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/verify-otp")
public class VerifyOtpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        int userOtp = Integer.parseInt(req.getParameter("otp"));
        HttpSession session = req.getSession();

        Object realOtpObj = session.getAttribute("otp");

        if (realOtpObj != null && userOtp == (int) realOtpObj) {
            res.sendRedirect("success.jsp");
        } else {
            res.getWriter().println("Invalid OTP. Please try again.");
        }
    }
}
