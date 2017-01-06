package ru.innopolis.uni.course3.ofedorova.servlets.tasks;

import ru.innopolis.uni.course3.ofedorova.controllers.ControllerForTasks;
import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoTasksException;
import ru.innopolis.uni.course3.ofedorova.models.Task;
import ru.innopolis.uni.course3.ofedorova.models.User;
import ru.innopolis.uni.course3.ofedorova.constants.Settings;
import ru.innopolis.uni.course3.ofedorova.servlets.ServletsCommon;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Сервлет для работы с выбранным заданием.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 27.12.2016
 */
public class SelectTaskServlet extends HttpServlet {
    /**
     * Объект-контроллер для работы с данными заданий.
     */
    private final ControllerForTasks controller = Settings.getControllerForTasks();

    /**
     * Вызывается сервером и позволяют сервлету обрабатывать GET-запрос.
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding(ServletsCommon.UTF_8);
            Integer id = Integer.valueOf(req.getParameter("id"));
            if (id == null) {
                resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/error.jsp"));
            } else {
                User user = ServletsCommon.getUserFromSession(req.getSession());
                if (user == null) {
                    resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/error.jsp"));
                } else {
                    Task task = null;
                    task = this.controller.getById(id, user.getId());
                    if (task == null) {
                        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/error.jsp"));
                    } else {
                        req.setCharacterEncoding(ServletsCommon.UTF_8);
                        req.setAttribute("name", task.getName());
                        req.setAttribute("id", task.getId());
                        req.setAttribute("content", task.getContent());
                        if (task.getDecision() == null) {
                            req.getRequestDispatcher("/main/tasks/SelectTask.jsp").forward(req, resp);
                        } else {
                            req.setAttribute("decision", task.getDecision().getDecision().replace("\r\n", "<br/>"));
                            req.setAttribute("mark", task.getMark().getMark());
                            req.getRequestDispatcher("/main/tasks/NotEditableTask.jsp").forward(req, resp);
                        }
                    }
                }
            }
        } catch (DAOtoTasksException e) {
            resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/error.jsp"));
        }
    }
}
