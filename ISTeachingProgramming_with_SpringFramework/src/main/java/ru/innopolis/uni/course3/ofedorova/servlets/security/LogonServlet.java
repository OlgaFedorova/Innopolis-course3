package ru.innopolis.uni.course3.ofedorova.servlets.security;

import ru.innopolis.uni.course3.ofedorova.controllers.ControllerForUsers;
import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoUsersException;
import ru.innopolis.uni.course3.ofedorova.models.User;
import ru.innopolis.uni.course3.ofedorova.constants.Settings;
import ru.innopolis.uni.course3.ofedorova.servlets.ServletsCommon;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Сервлет для работы механизма "Вход в систему".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 25.12.2016
 */
public class LogonServlet extends HttpServlet {

    /**
     * Объект-контроллер для работы с данными пользователя.
     */
    private final ControllerForUsers controller = Settings.getControllerForUsers();

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
            req.getRequestDispatcher("/security/logon.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher(String.format("%s%s", req.getContextPath(), "/info-about-authorization")).forward(req, resp);
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
        try {
            String username = req.getParameter("username");
            String password = req.getParameter("user_password");

            User user = null;
            user = this.controller.validateLogin(username, password);
            if (user == null) {
                req.getRequestDispatcher(String.format("%s%s", req.getContextPath(), "/security/logonError.jsp")).forward(req, resp);
            } else {
                ServletsCommon.setUserInSession(req.getSession(), user);
                resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/security/success-logon"));
            }
        } catch (DAOtoUsersException e) {
            resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/error.jsp"));
        }
    }
}
