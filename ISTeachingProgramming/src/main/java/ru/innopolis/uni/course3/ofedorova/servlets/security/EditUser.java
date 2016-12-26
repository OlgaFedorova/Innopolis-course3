package ru.innopolis.uni.course3.ofedorova.servlets.security;

import ru.innopolis.uni.course3.ofedorova.controllers.ControllerForUsers;
import ru.innopolis.uni.course3.ofedorova.models.User;
import ru.innopolis.uni.course3.ofedorova.servlets.ServletsCommon;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Сервлет для работы механизма "Редактирование пользователя".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 26.12.2016
 */
public class EditUser extends HttpServlet {
    /**
     * Объект-контроллер для работы с данными пользователя.
     */
    private final ControllerForUsers controller = new ControllerForUsers();


    /**
     * Вызывается сервером и позволяют сервлету обрабатывать GET-запрос.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = ServletsCommon.getUserFromSession(req.getSession());
        if(user == null){
            req.getRequestDispatcher("/security/logon").forward(req, resp);
        }else{
            req.setAttribute("username", user.getName());
            req.getRequestDispatcher("/security/edit-user.jsp").forward(req, resp);
        }
    }

    /**
     * Вызывается сервером и позволяют сервлету обрабатывать POST-запрос.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currentPassword = req.getParameter("current_password");
        String newPassword = req.getParameter("new_password");
        String confirmPassword = req.getParameter("confirm_password");
        if(ServletsCommon.getUserFromSession(req.getSession()) != null
                && this.controller.checkDataForEdid(ServletsCommon.getUserFromSession(req.getSession()).getId(), currentPassword, newPassword, confirmPassword)){
            User user = this.controller.updatePassword(ServletsCommon.getUserFromSession(req.getSession()).getId(), newPassword);
            ServletsCommon.setUserInSession(req.getSession(), user);
            resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/main/edit-user-success"));
        }else{
            req.getRequestDispatcher("/security/edit-user-error.jsp").forward(req, resp);
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
