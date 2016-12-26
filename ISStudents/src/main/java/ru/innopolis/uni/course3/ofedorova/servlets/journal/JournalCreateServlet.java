package ru.innopolis.uni.course3.ofedorova.servlets.journal;

import ru.innopolis.uni.course3.ofedorova.dao.journal.JournalCache;
import ru.innopolis.uni.course3.ofedorova.models.Journal;
import ru.innopolis.uni.course3.ofedorova.models.Lecture;
import ru.innopolis.uni.course3.ofedorova.models.Student;
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
public class JournalCreateServlet extends HttpServlet {

    private final JournalCache journalCache = (JournalCache) Settings.APPLICATION_CONTEXT.getBean("journalCache");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("lectures", this.journalCache.getLectures());
        req.setAttribute("students", this.journalCache.getStudents());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/journal/CreateJournal.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String date = req.getParameter("date");
        Lecture lecture = this.journalCache.getLecture(Integer.valueOf(req.getParameter("subject")));
        Student student = this.journalCache.getStudent(Integer.valueOf(req.getParameter("student")));
        this.journalCache.add(new Journal(this.journalCache.generateId(), date, lecture, student));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/journal/view"));
    }

    @Override
    public void destroy() {
        super.destroy();
        this.journalCache.close();
    }
}
