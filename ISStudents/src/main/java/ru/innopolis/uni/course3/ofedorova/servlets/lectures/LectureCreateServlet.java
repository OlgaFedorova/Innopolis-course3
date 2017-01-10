package ru.innopolis.uni.course3.ofedorova.servlets.lectures;

import ru.innopolis.uni.course3.ofedorova.dao.lectures.LectureCache;
import ru.innopolis.uni.course3.ofedorova.models.Lecture;
import ru.innopolis.uni.course3.ofedorova.services.Settings;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Olga on 22.12.2016.
 */
public class LectureCreateServlet extends HttpServlet {

    private final LectureCache lectureCache = (LectureCache) Settings.APPLICATION_CONTEXT.getBean("lectureCache");

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.lectureCache.add(new Lecture(this.lectureCache.generateId(), req.getParameter("subject"), Integer.valueOf(req.getParameter("hours_of_theory")), Integer.valueOf(req.getParameter("hours_of_practice"))));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/lecture/view"));
    }

    @Override
    public void destroy() {
        super.destroy();
        this.lectureCache.close();
    }
}
