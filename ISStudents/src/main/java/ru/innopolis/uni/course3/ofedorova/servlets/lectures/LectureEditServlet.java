package ru.innopolis.uni.course3.ofedorova.servlets.lectures;

import ru.innopolis.uni.course3.ofedorova.models.Lecture;
import ru.innopolis.uni.course3.ofedorova.dao.lectures.LectureCache;
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
public class LectureEditServlet extends HttpServlet {

    private final LectureCache lectureCache = (LectureCache) Settings.APPLICATION_CONTEXT.getBean("lectureCache");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Lecture lecture = this.lectureCache.get(Integer.valueOf(id));
        req.setAttribute("id", id);
        req.setAttribute("subject", lecture.getSubject());
        req.setAttribute("hours_of_theory", lecture.getHoursOfTheory());
        req.setAttribute("hours_of_practice", lecture.getHoursOfPractice());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/lecture/EditLecture.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.lectureCache.edit(new Lecture(Integer.valueOf(req.getParameter("id")), req.getParameter("subject"), Integer.valueOf(req.getParameter("hours_of_theory")), Integer.valueOf(req.getParameter("hours_of_practice"))));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/lecture/view"));
    }

    @Override
    public void destroy() {
        super.destroy();
        this.lectureCache.close();
    }
}
