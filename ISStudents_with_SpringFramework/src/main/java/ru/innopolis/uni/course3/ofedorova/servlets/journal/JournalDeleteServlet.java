package ru.innopolis.uni.course3.ofedorova.servlets.journal;

import ru.innopolis.uni.course3.ofedorova.controllers.JournalController;
import ru.innopolis.uni.course3.ofedorova.service.Settings;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Olga on 22.12.2016.
 */
public class JournalDeleteServlet extends HttpServlet {

    private final JournalController journalController = (JournalController) Settings.APPLICATION_CONTEXT.getBean("journal_controller");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.journalController.delete(Integer.valueOf(req.getParameter("id")));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/journal/view"));
    }
}

