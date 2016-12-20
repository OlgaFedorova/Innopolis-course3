package ru.innopolis.uni.course3.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Olga on 19.12.2016.
 */
public class HelloWorldServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        //PrintWriter out = resp.getWriter();
        //out.print("<h1>Hello Servlet</h1>");

        //resp.getOutputStream().write("Hello World.".getBytes());


        String name = req.getParameter("name");

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        try (PrintWriter writer = resp.getWriter()) {

            writer.println("<!DOCTYPE html><html>");
            writer.println("<head>");
            writer.println("<meta charset=\"UTF-8\" />");
            writer.println("<title>MyServlet.java:doGet(): StartServlet code!</title>");
            writer.println("</head>");
            writer.println("<body>");

            writer.println("<h1>Hello, " + name + "</h1>");

            writer.println("</body>");
            writer.println("</html>");
        }

    }
}
