package ru.innopolis.uni.course3.ofedorova.servlets.security;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import ru.innopolis.uni.course3.ofedorova.controllers.ControllerForUsers;
import ru.innopolis.uni.course3.ofedorova.dao.users.JdbcOfDAOtoUsers;
import ru.innopolis.uni.course3.ofedorova.models.User;
import ru.innopolis.uni.course3.ofedorova.service.ConnectionPoolFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;

import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.whenNew;

/**
 * Класс для тестирования EditUser.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 27.12.2016
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ConnectionPoolFactory.class, JdbcOfDAOtoUsers.class, ControllerForUsers.class})
public class EditUserTest {
    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    @Mock
    RequestDispatcher dispatcher;
    @Mock
    ControllerForUsers controller;
    @Mock
    HttpSession session;
    @Mock
    JdbcOfDAOtoUsers jdbcOfDAOtoUsers;
    @Mock
    Connection connection;

    /**
     * Инициализация.
     *
     * @throws Exception
     */
    @Before
    public void init() throws Exception {
        mockStatic(ConnectionPoolFactory.class);
        when(ConnectionPoolFactory.getConnection()).thenReturn(connection);
        mock(JdbcOfDAOtoUsers.class);
        whenNew(JdbcOfDAOtoUsers.class).withNoArguments().thenReturn(jdbcOfDAOtoUsers);
        mock(ControllerForUsers.class);
        whenNew(ControllerForUsers.class).withNoArguments().thenReturn(controller);
        when(request.getSession()).thenReturn(session);
    }

    /**
     * Метод проверяет вызов метода "doGet" и переход на страницу авторизации.
     *
     * @throws Exception
     */
    @Test
    public void whenDoGetAndGoLogon() throws Exception {
        final User user = null;

        when(session.getAttribute("user")).thenReturn(user);
        when(request.getRequestDispatcher("/security/logon")).thenReturn(dispatcher);

        final EditUser editUser = new EditUser();
        editUser.doGet(request, response);

        verify(request, atLeastOnce()).getRequestDispatcher("/security/logon");
    }

    /**
     * Метод проверяет вызов метода "doGet" и переход на страницу редактирования профиля.
     *
     * @throws Exception
     */
    @Test
    public void whenDoGetAndGoEditUser() throws Exception {
        final User user = new User(1, "name", "password");

        when(session.getAttribute("user")).thenReturn(user);
        when(request.getRequestDispatcher("/security/edit-user.jsp")).thenReturn(dispatcher);

        final EditUser editUser = new EditUser();
        editUser.doGet(request, response);

        verify(request, atLeastOnce()).getRequestDispatcher("/security/edit-user.jsp");
    }

    /**
     * Метод тестирует вызов метода "doPost" и сообщает об успешном редактировании.
     *
     * @throws Exception
     */
    @Test
    public void whenDoPostAndEditSuccess() throws Exception {
        final String name = "test_name";
        final String password = "test_password";
        final String newPassword = "test_password1";
        final String confirmPassword = newPassword;
        final int id = 1;
        final User userCurrent = new User(id, name, password);
        final User userNew = new User(id, name, newPassword);

        when(session.getAttribute("user")).thenReturn(userCurrent);
        when(request.getParameter("current_password")).thenReturn(password);
        when(request.getParameter("new_password")).thenReturn(newPassword);
        when(request.getParameter("confirm_password")).thenReturn(confirmPassword);
        when(jdbcOfDAOtoUsers.updatePassword(id, newPassword)).thenReturn(userNew);
        when(jdbcOfDAOtoUsers.getPassword(id)).thenReturn(password);

        final EditUser editUser = new EditUser();
        editUser.doPost(request, response);

        verify(request, atLeastOnce()).getParameter("current_password");
        verify(request, atLeastOnce()).getParameter("new_password");
        verify(request, atLeastOnce()).getParameter("confirm_password");
        verify(jdbcOfDAOtoUsers, atLeastOnce()).updatePassword(id, newPassword);
        verify(jdbcOfDAOtoUsers, atLeastOnce()).getPassword(id);
    }

    /**
     * Метод тестирует вызов метода "doPost" и сообщает об ошибке редактирования профиля.
     *
     * @throws Exception
     */
    @Test
    public void whenDoPostAndErrorEdit() throws Exception {
        final String name = "test_name";
        final String password = "test_password";
        final String newPassword = "test_password1";
        final String confirmPassword = "test_password2";
        final int id = 1;
        final User userCurrent = new User(id, name, password);
        final User userNew = new User(id, name, newPassword);

        when(session.getAttribute("user")).thenReturn(userCurrent);
        when(request.getParameter("current_password")).thenReturn(password);
        when(request.getParameter("new_password")).thenReturn(newPassword);
        when(request.getParameter("confirm_password")).thenReturn(confirmPassword);
        when(jdbcOfDAOtoUsers.updatePassword(id, newPassword)).thenReturn(userNew);
        when(jdbcOfDAOtoUsers.getPassword(id)).thenReturn(password);
        when(request.getRequestDispatcher("/security/edit-user-error.jsp")).thenReturn(dispatcher);

        final EditUser editUser = new EditUser();
        editUser.doPost(request, response);

        verify(request, atLeastOnce()).getParameter("current_password");
        verify(request, atLeastOnce()).getParameter("new_password");
        verify(request, atLeastOnce()).getParameter("confirm_password");
        verify(jdbcOfDAOtoUsers, atLeast(0)).updatePassword(id, newPassword);
        verify(jdbcOfDAOtoUsers, atLeastOnce()).getPassword(id);
        verify(request, atLeastOnce()).getRequestDispatcher("/security/edit-user-error.jsp");
    }

}