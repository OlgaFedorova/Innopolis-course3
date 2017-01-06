package ru.innopolis.uni.course3.ofedorova.servlets.lectures;

import ru.innopolis.uni.course3.ofedorova.controllers.LectureController;
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
public class LectureViewServlet extends HttpServlet {

    private final LectureController lectureController = (LectureController) Settings.APPLICATION_CONTEXT.getBean("lecture_controller");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("lectures", this.lectureController.valuesLectures());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/lecture/LectureView.jsp");
        dispatcher.forward(req, resp);
    }
}
