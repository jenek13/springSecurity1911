package ru.ten.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.ten.crud.model.User;
import ru.ten.crud.service.UserServiceImpl;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/signup")
public class SignUpServlet {

    @Autowired
    UserServiceImpl userServiceImpl;

    public void doPost(HttpServletRequest request,
                           HttpServletResponse response) throws IOException {
            String login = request.getParameter("login");
            String pass  = request.getParameter("password");
            String name  = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            String role = request.getParameter("role");
            if (login  == null || pass  == null) {
                response.setContentType("text/html;charset=utf-8");
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }
            try {
                userServiceImpl.insertUserByLogin(login, pass, name, age, role);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().println("Authorized: " + login);

        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            RequestDispatcher dispatcher = request.getRequestDispatcher("register-form.jsp");
            dispatcher.forward(request, response);
        }


    @RequestMapping(value = {"/admin"}, method = RequestMethod.GET)
    public ModelAndView read(ModelMap model) {
        ModelAndView mv = new ModelAndView();
        List<User> list = userServiceImpl.listUser();
        model.addAttribute("user-list", list);
        mv.setViewName("user-list");
        return mv;
    }

}


