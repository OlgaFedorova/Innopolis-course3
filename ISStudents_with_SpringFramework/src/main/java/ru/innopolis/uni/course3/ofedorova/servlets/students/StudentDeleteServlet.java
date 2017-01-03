package ru.innopolis.uni.course3.ofedorova.servlets.students;

import ru.innopolis.uni.course3.ofedorova.controllers.StudentController;
import ru.innopolis.uni.course3.ofedorova.service.Settings;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Olga on 22.12.2016.
 */
public class StudentDeleteServlet extends HttpServlet {

    private final StudentController studentController = (StudentController) Settings.APPLICATION_CONTEXT.getBean("students_controller");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.studentController.delete(Integer.valueOf(req.getParameter("id")));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/student/view"));
    }
}

