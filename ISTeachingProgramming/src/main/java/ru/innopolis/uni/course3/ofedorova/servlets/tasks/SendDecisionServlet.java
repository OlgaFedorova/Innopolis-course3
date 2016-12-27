package ru.innopolis.uni.course3.ofedorova.servlets.tasks;

import ru.innopolis.uni.course3.ofedorova.controllers.ControllerForDecisionsAndMarks;
import ru.innopolis.uni.course3.ofedorova.models.User;
import ru.innopolis.uni.course3.ofedorova.servlets.ServletsCommon;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Сервлет для отправки решенного задания на сервер.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 27.12.2016
 */
public class SendDecisionServlet extends HttpServlet {
    /**
     * Объект-контроллер для работы с данными решений.
     */
    private final ControllerForDecisionsAndMarks controller = new ControllerForDecisionsAndMarks();

    /**
     * Вызывается сервером и позволяют сервлету обрабатывать POST-запрос.
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(ServletsCommon.UTF_8);
        String decision = req.getParameter("decision");
        Integer idTask = Integer.valueOf(req.getParameter("id"));
        User user = ServletsCommon.getUserFromSession(req.getSession());
        if (idTask == null && user == null) {
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        } else {
            if (decision != null && !decision.isEmpty()) {
                this.controller.add(idTask, user.getId(), decision);
            }
            resp.sendRedirect(String.format("%s%s%s", req.getContextPath(), "/main/tasks/select?id=", idTask));
        }
    }
}
