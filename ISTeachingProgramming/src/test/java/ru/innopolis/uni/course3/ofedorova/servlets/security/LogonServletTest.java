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
 * Класс для тестирования LogonServlet.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 27.12.2016
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ConnectionPoolFactory.class, JdbcOfDAOtoUsers.class, ControllerForUsers.class})
public class LogonServletTest {
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
     * Метод тестирует вызов "doGet" и переход на страницу авторизации.
     * @throws Exception
     */
    @Test
    public void whenDoGetAndGoLogon() throws Exception {
        final User user = null;

        when(session.getAttribute("user")).thenReturn(user);
        when(request.getRequestDispatcher("/security/logon.jsp")).thenReturn(dispatcher);

        final LogonServlet logonServlet = new LogonServlet();
        logonServlet.doGet(request, response);

        verify(request, atLeastOnce()).getRequestDispatcher("/security/logon.jsp");
    }

    /**
     * Метод тестирует вызов "doGet" и переход на страницу информирования о том, что пользователь уже авторизован.
     * @throws Exception
     */
    @Test
    public void whenDoGetAndGoInfoAuthorization() throws Exception {
        final User user = new User(1, "name", "password");

        when(session.getAttribute("user")).thenReturn(user);
        when(request.getRequestDispatcher(String.format("%s%s", request.getContextPath(), "/info-about-authorization"))).thenReturn(dispatcher);

        final LogonServlet logonServlet = new LogonServlet();
        logonServlet.doGet(request, response);

        verify(request, atLeastOnce()).getRequestDispatcher(String.format("%s%s", request.getContextPath(), "/info-about-authorization"));
    }

    /**
     * Метод тестирует вызов "doPost" и переход на страницу ошибки авторизации.
     * @throws Exception
     */
    @Test
    public void whenDoPostAndGoLogonError() throws Exception {
        final String name = "test_name";
        final String password = "test_password";
        final String passwordDB = "test_password1";
        final int id = 1;
        final User user = new User(id, name, passwordDB);

        when(request.getParameter("username")).thenReturn(name);
        when(request.getParameter("user_password")).thenReturn(password);
        when(jdbcOfDAOtoUsers.getByName(name)).thenReturn(user);
        when(request.getRequestDispatcher(String.format("%s%s", request.getContextPath(), "/security/logonError.jsp"))).thenReturn(dispatcher);

        final LogonServlet logonServlet = new LogonServlet();
        logonServlet.doPost(request, response);

        verify(request, atLeastOnce()).getParameter("username");
        verify(request, atLeastOnce()).getParameter("user_password");
        verify(jdbcOfDAOtoUsers, atLeastOnce()).getByName(name);
        verify(request, atLeastOnce()).getRequestDispatcher(String.format("%s%s", request.getContextPath(), "/security/logonError.jsp"));
    }

    /**
     * Метод тестирует вызов "doPost" и переход на страницу об успешной авторизации.
     * @throws Exception
     */
    @Test
    public void whenDoPostAndGoLogonSuccess() throws Exception {
        final String name = "test_name";
        final String password = "test_password";
        final int id = 1;
        final User user = new User(id, name, password);

        when(request.getParameter("username")).thenReturn(name);
        when(request.getParameter("user_password")).thenReturn(password);
        when(jdbcOfDAOtoUsers.getByName(name)).thenReturn(user);
        when(request.getRequestDispatcher(String.format("%s%s", request.getContextPath(), "/security/logonError.jsp"))).thenReturn(dispatcher);

        final LogonServlet logonServlet = new LogonServlet();
        logonServlet.doPost(request, response);

        verify(request, atLeastOnce()).getParameter("username");
        verify(request, atLeastOnce()).getParameter("user_password");
        verify(jdbcOfDAOtoUsers, atLeastOnce()).getByName(name);
        verify(request, atLeast(0)).getRequestDispatcher(String.format("%s%s", request.getContextPath(), "/security/logonError.jsp"));
    }

}