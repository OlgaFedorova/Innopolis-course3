package ru.innopolis.uni.course3.ofedorova.servlets;

import ru.innopolis.uni.course3.ofedorova.models.Student;
import ru.innopolis.uni.course3.ofedorova.store.storageofstudents.StudentCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Olga on 22.12.2016.
 */
public class StudentCreateServlet extends HttpServlet {

    private final StudentCache studentCache = new StudentCache();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.studentCache.add(new Student(this.studentCache.generateId(), req.getParameter("name"), req.getParameter("class")));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/student/view"));
    }

    @Override
    public void destroy() {
        super.destroy();
        this.studentCache.close();
    }
}
