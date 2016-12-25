package ru.innopolis.uni.course3.ofedorova.servlets.security;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Сервлет для работы механизма "Выход из системы".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 25.12.2016
 */
public class LogoutServlet extends HttpServlet {

    /**
     * Вызывается сервером и позволяют сервлету обрабатывать запрос GET-запрос.
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("user", null);
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/security/success-logout.jsp"));
    }
}
