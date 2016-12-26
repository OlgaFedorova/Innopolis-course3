package ru.innopolis.uni.course3.ofedorova.servlets.lectures;

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
public class LectureViewServlet extends HttpServlet {

    private final LectureCache lectureCache = (LectureCache) Settings.APPLICATION_CONTEXT.getBean("lectureCache");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("lectures", this.lectureCache.values());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/lecture/LectureView.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
        this.lectureCache.close();
    }
}
