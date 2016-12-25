package ru.innopolis.uni.course3.ofedorova.servlets.security;

import ru.innopolis.uni.course3.ofedorova.controllers.ControllerForUsers;
import ru.innopolis.uni.course3.ofedorova.models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Сервлет для работы механизма "Регистрация".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 25.12.2016
 */
public class UserCreateServlet extends HttpServlet {
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
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/registration.jsp");
            dispatcher.forward(req, resp);
        } else {
            resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/info-about-authorization.jsp"));
        }
    }

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
        String username = req.getParameter("name");

        if (this.controller.checkPasswords(req.getParameter("user_password"), req.getParameter("confirm_user_password"))) {
            User user = this.controller.addNewUser(username, req.getParameter("user_password"));
            if (user != null) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/registration-success.jsp"));
            } else {
                resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/registrationError.jsp"));
            }
        } else {
            req.setAttribute("info", "Пароли не совпадают, попробуйте снова.");
            req.setAttribute("username", username);
            req.getRequestDispatcher("/registration.jsp").forward(req, resp);
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
