package ru.innopolis.uni.course3.ofedorova.servlets.tasks;

import ru.innopolis.uni.course3.ofedorova.controllers.ControllerForTasks;
import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoTasksException;
import ru.innopolis.uni.course3.ofedorova.models.User;
import ru.innopolis.uni.course3.ofedorova.service.Settings;
import ru.innopolis.uni.course3.ofedorova.servlets.security.ServletsCommon;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Сервлет для работы со списком заданий.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 27.12.2016
 */
public class TaskViewServlet extends HttpServlet {
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
            User user = ServletsCommon.getUserFromSession(req.getSession());
            if (user == null) {
                resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/error.jsp"));
            } else {
                req.setAttribute("tasks", this.controller.values(user.getId()));
                req.getRequestDispatcher("/main/tasks/TasksView.jsp").forward(req, resp);
            }
        } catch (DAOtoTasksException e) {
            resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/error.jsp"));
        }
    }
}
