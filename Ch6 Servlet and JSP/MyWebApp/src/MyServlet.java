// servlets
package com.example;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class MyServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Hello World");
    }

    public static void main(String[] args) {
        MyServlet();
    }
}

//
//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import jakarta.servlet.annotation.*;
//
//
//@WebServlet("/lifecycle")
//public class MyServlet extends HttpServlet {
//
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
//        System.out.println("Servlet Initialization");
//    }
//
////    @Override
//    protected void Service(HttpServletRequest request, HttpServletResponse response)
//            throws Exception {
//        System.out.println("Service method called...");
//    }
//
//    @Override
//    public void destroy() {
//        System.out.println("Servlet is being destroyed");
//    }
//}
