package ru.innopolis.uni.course3.ofedorova.security;

import ru.innopolis.uni.course3.ofedorova.common.models.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Класс реализует фильтр для защиты секретной части системы.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 25.12.2016
 */
public class SecurityFilter implements Filter {
    /**
     * Значение параметра фмльтра.
     */
    private String parametrOfFilter;

    /**
     * Метод инициализации фильтра.
     *
     * @param filterConfig конфигурация фильтра (WEB-INF\web.xml).
     * @throws ServletException возникшая ошибка.
     * @see Filter#init(FilterConfig)
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.parametrOfFilter = filterConfig.getInitParameter("loginActionURI");
    }

    /**
     * Метод фильтрации.
     * Если значение атрибута "user" в сессии заполнено, то получаем доступ к секретной части системы,
     * иначе переходим на страницу авторизации.
     *
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null && !this.parametrOfFilter.equals(req.getRequestURI())) {
            RequestDispatcher rd = req.getRequestDispatcher("/security/logon.jsp");
            rd.forward(request, response);
            return;
        }
        chain.doFilter(request, response);
    }

    /**
     * Метод освобождения ресурсов.
     *
     * @see Filter#destroy()
     */
    @Override
    public void destroy() {
    }
}
