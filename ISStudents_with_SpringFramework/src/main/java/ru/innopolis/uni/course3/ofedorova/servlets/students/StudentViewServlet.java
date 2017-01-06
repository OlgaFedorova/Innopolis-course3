package ru.innopolis.uni.course3.ofedorova.servlets.students;

import ru.innopolis.uni.course3.ofedorova.controllers.StudentController;
import ru.innopolis.uni.course3.ofedorova.service.Settings;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Olga on 22.12.2016.
 */
public class StudentViewServlet extends HttpServlet {

    private final StudentController studentController = (StudentController) Settings.APPLICATION_CONTEXT.getBean("students_controller");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("students", this.studentController.getStudents());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/student/StudentView.jsp");
        dispatcher.forward(req, resp);
    }
}
