package ru.innopolis.uni.course3.ofedorova.servlets.lectures;

import ru.innopolis.uni.course3.ofedorova.dao.lectures.LectureCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Olga on 22.12.2016.
 */
public class LectureDeleteServlet extends HttpServlet {

    private final LectureCache lectureCache = new LectureCache();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.lectureCache.delete(Integer.valueOf(req.getParameter("id")));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/lecture/view"));
    }

    @Override
    public void destroy() {
        super.destroy();
        this.lectureCache.close();
    }
}

