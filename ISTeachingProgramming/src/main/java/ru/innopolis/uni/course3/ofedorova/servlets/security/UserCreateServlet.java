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
 * Created by Olga on 22.12.2016.
 */
public class UserCreateServlet extends HttpServlet {

    private final ControllerForUsers cashOfUsers = new ControllerForUsers();

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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("name");

        if (this.cashOfUsers.checkPasswords(req.getParameter("user_password"), req.getParameter("confirm_user_password"))) {
            User user = this.cashOfUsers.addNewUser(username, req.getParameter("user_password"));
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

    @Override
    public void destroy() {
        super.destroy();
        this.cashOfUsers.close();
    }
}
