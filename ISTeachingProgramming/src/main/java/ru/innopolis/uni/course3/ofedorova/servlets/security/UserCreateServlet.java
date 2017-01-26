package ru.innopolis.uni.course3.ofedorova.servlets.security;

import ru.innopolis.uni.course3.ofedorova.common.controllers.ControllerForUsers;
import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoUsersException;
import ru.innopolis.uni.course3.ofedorova.common.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        if (ServletsCommon.getUserFromSession(req.getSession()) == null) {
            req.getRequestDispatcher("/registration/registration.jsp").forward(req, resp);
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
            String username = req.getParameter("name");

            if (!this.controller.checkName(username)) {
                req.getRequestDispatcher("/registration/registrationErrorNameIncorrect.jsp").forward(req, resp);
            } else if (this.controller.getByName(username) != null) {
                req.getRequestDispatcher(String.format("%s%s", req.getContextPath(), "/registration/registrationErrorUserDuplicate.jsp")).forward(req, resp);
            } else {
                if (this.controller.passwordEmpty(req.getParameter("user_password"), req.getParameter("confirm_user_password"))) {
                    req.getRequestDispatcher(String.format("%s%s", req.getContextPath(), "/registration/registrationErrorPasswordEmpty.jsp")).forward(req, resp);
                } else {
                    if (this.controller.checkPasswords(req.getParameter("user_password"), req.getParameter("confirm_user_password"))) {
                        User user = null;
                        user = this.controller.addNewUser(username, req.getParameter("user_password"));
                        ServletsCommon.setUserInSession(req.getSession(), user);
                        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/registration-success"));
                    } else {
                        req.setCharacterEncoding(ServletsCommon.UTF_8);
                        req.setAttribute("info", "Пароли не совпадают, попробуйте снова.");
                        req.setAttribute("username", username);
                        req.getRequestDispatcher("/registration/registration.jsp").forward(req, resp);
                    }
                }
            }
        } catch (DAOtoUsersException e) {
            resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/error.jsp"));
        }
    }
}
