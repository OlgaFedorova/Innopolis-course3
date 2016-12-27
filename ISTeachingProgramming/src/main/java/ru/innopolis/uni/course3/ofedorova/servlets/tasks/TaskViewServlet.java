package ru.innopolis.uni.course3.ofedorova.servlets.tasks;

import ru.innopolis.uni.course3.ofedorova.controllers.ControllerForTasks;
import ru.innopolis.uni.course3.ofedorova.models.User;
import ru.innopolis.uni.course3.ofedorova.servlets.ServletsCommon;

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
    private final ControllerForTasks controller = new ControllerForTasks();

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
        User user = ServletsCommon.getUserFromSession(req.getSession());
        if (user == null) {
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        } else {
            req.setAttribute("tasks", this.controller.values(user.getId()));
            req.getRequestDispatcher("/main/tasks/TasksView.jsp").forward(req, resp);
        }

    }

    /**
     * Вызывается контейнером сервлета в момент закрытия сервлета.
     */
    @Override
    public void destroy() {
        super.destroy();
        this.controller.close();
    }
}
