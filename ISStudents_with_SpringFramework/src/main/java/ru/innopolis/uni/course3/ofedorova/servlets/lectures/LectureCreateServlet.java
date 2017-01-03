package ru.innopolis.uni.course3.ofedorova.servlets.lectures;

import ru.innopolis.uni.course3.ofedorova.controllers.LectureController;
import ru.innopolis.uni.course3.ofedorova.models.Lecture;
import ru.innopolis.uni.course3.ofedorova.service.Settings;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Olga on 22.12.2016.
 */
public class LectureCreateServlet extends HttpServlet {

    private final LectureController lectureController = (LectureController) Settings.APPLICATION_CONTEXT.getBean("lecture_controller");

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.lectureController.add(new Lecture(this.lectureController.generateId(), req.getParameter("subject"), Integer.valueOf(req.getParameter("hours_of_theory")), Integer.valueOf(req.getParameter("hours_of_practice"))));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/lecture/view"));
    }
}
