package ru.innopolis.uni.course3.ofedorova.servlets;

import ru.innopolis.uni.course3.ofedorova.servlets.ServletsCommon;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        ServletsCommon.setUserInSession(req.getSession(), null);
        req.getRequestDispatcher(String.format("%s%s", req.getContextPath(), "/security/success-logout.jsp")).forward(req, resp);
    }
}
