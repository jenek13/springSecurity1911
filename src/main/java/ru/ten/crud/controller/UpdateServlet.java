package ru.ten.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.ten.crud.model.User;
import ru.ten.crud.service.UserServiceImpl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/adminedit")
public class UpdateServlet {

    @Autowired
    UserServiceImpl userServiceImpl;

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
            request.setCharacterEncoding("utf-8");
            int id = Integer.parseInt(request.getParameter("id"));
            String newname = request.getParameter("name");
            int newage = Integer.parseInt(request.getParameter("age"));
            String role = request.getParameter("role");
            userServiceImpl.updateUser(id,newname,newage, role);
            response.sendRedirect("admin");
        }

        @RequestMapping(value = { "/adminedit" }, method = RequestMethod.POST)
        public ModelAndView updateUser(@Valid User user, BindingResult result, ModelMap model,
                                      @PathVariable Long id) {
            ModelAndView mv = new ModelAndView();
            String role = user.getRole();
                if (role == null) {
            model.addAttribute("student", user);
            model.addAttribute("edit", true);
            model.addAttribute("error", "Grade must be Numeric.");
            mv.setViewName("addStudentForm");
                } else {
                    userServiceImpl.updateUser(2,"name", 6, "role");
            List<User> list = userServiceImpl.listUser();
            model.addAttribute("allstudents", list);

            mv.setViewName("allStudents");
                }
            return mv;
        }


        @RequestMapping(value = { "/adminedit}" }, method = RequestMethod.GET)
            public String editUser(@PathVariable int id, ModelMap model) throws SQLException {
            User user = userServiceImpl.selectUser(id);
            model.addAttribute("user", user);
            model.addAttribute("edit", true);
            return "user-form";
        }
}
