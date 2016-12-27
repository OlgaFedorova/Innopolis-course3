package ru.innopolis.uni.course3.ofedorova.servlets.marks;

import ru.innopolis.uni.course3.ofedorova.controllers.ControllerForUsers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Сервлет для отображения рейтинга пользователей.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 27.12.2016
 */
public class UserRatingServlet extends HttpServlet {
    /**
     * Объект-контроллер для работы с данными пользователя.
     */
    private final ControllerForUsers controller = new ControllerForUsers();

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
        req.setAttribute("users", this.controller.valuesRating());
        req.getRequestDispatcher("/main/marks/UserRatingView.jsp").forward(req, resp);
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
