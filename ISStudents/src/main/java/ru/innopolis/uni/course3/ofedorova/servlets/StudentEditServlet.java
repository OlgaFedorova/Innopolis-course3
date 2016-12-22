package ru.innopolis.uni.course3.ofedorova.servlets;

import ru.innopolis.uni.course3.ofedorova.store.storageofstudents.StudentCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Olga on 22.12.2016.
 */
public class StudentEditServlet extends HttpServlet {

    private final StudentCache studentCache = new StudentCache();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("student", this.studentCache.get(Integer.valueOf(req.getParameter("id"))));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/student/EditStudent.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
        this.studentCache.close();
    }
}
