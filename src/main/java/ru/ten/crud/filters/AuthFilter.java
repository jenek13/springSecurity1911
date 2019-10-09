package ru.ten.crud.filters;

import ru.ten.crud.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName="authFilter", urlPatterns="/authFilter")
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession(false);
        //HttpSession s = req.getSession().getAttributeNames("login", "password", "name", "role", "age", "role");
        User user = (User) session.getAttribute("user");
        if (user == null) {
            //if (user.getLogin() == null) {
            res.sendRedirect(req.getContextPath() + "/login"); // нет активной сессии или нет такого юзера с таким логином то вернуть на логин страницу(сайн ин сервлет)
        } else {
            filterChain.doFilter(req, res);
        }

    }

    @Override
    public void destroy() {

    }
}
