package ru.ten.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.ten.crud.model.User;
import ru.ten.crud.service.UserServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/admindelete")
public class DeleteServlet {

    @Autowired
    UserServiceImpl userServiceImpl;

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            try {
                userServiceImpl.deleteUser(id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            response.sendRedirect("admin");
        }


    @RequestMapping(value = { "/admindelete" }, method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable Long id, ModelMap model) throws SQLException {
        ModelAndView mv = new ModelAndView();
        User user = userServiceImpl.selectUser(Math.toIntExact(id));
        userServiceImpl.deleteUser(Math.toIntExact(id));
        List<User> list = userServiceImpl.listUser();
        model.addAttribute("user-list", list);
        mv.setViewName("user-list");
        return mv;
    }
}
