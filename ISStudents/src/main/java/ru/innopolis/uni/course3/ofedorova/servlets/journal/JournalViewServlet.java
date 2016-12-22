package ru.innopolis.uni.course3.ofedorova.servlets.journal;

import ru.innopolis.uni.course3.ofedorova.store.journal.JournalCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Olga on 22.12.2016.
 */
public class JournalViewServlet extends HttpServlet {

    private final JournalCache journalCache = new JournalCache();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("records", this.journalCache.values());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/journal/JournalView.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
        this.journalCache.close();
    }
}
