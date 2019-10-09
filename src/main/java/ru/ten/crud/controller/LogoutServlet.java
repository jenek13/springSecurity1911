package ru.ten.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.ten.crud.service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@Controller
@RequestMapping("/adminnew")
public class LogoutServlet {

    @Autowired
    UserServiceImpl userServiceImpl;

        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws IOException {
            request.setCharacterEncoding("utf-8");
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            String role = request.getParameter("role");
            try {
                userServiceImpl.insertUser(name, age, role);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            response.sendRedirect("admin");
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
            dispatcher.forward(request, response);
        }
}
