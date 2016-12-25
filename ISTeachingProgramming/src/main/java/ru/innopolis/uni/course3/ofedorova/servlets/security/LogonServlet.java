package ru.innopolis.uni.course3.ofedorova.servlets.security;

import ru.innopolis.uni.course3.ofedorova.models.User;
import ru.innopolis.uni.course3.ofedorova.controllers.ControllerForUsers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Сервлет для работы механизма "Вход в систему".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 25.12.2016
 */
public class LogonServlet extends HttpServlet {

    private final ControllerForUsers cashOfUsers = new ControllerForUsers();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/security/logon.jsp");
            dispatcher.forward(req, resp);
        } else {
            resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/info-about-authorization.jsp"));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        String username = req.getParameter("username");
        String password = req.getParameter("user_password");

        User user = this.cashOfUsers.validateLogin(username, password);

        if (user == null) {
            requestDispatcher = req.getRequestDispatcher("/security/logonError.jsp");
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            requestDispatcher = req.getRequestDispatcher("/security/success-logon.jsp");
        }
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
        this.cashOfUsers.close();
    }
}
