package ru.ten.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.ten.crud.model.User;
import ru.ten.crud.service.UserServiceImpl;
import java.util.List;

@Controller
@RequestMapping("adminnew")
public class CreateServlet {

    @Autowired
    UserServiceImpl userServiceImpl;

        @RequestMapping(value = { "/adminnew" }, method = RequestMethod.POST)
            public String newStudentForm(ModelMap model) {
            User newUser = new User("name", 5, "role");
            model.addAttribute("user", newUser);
            model.addAttribute("edit", false);
            return "user-form";
        }

        @RequestMapping(value = {"/adminnew"}, method = RequestMethod.GET)
         public ModelAndView readbeforecreate(ModelMap model) {
            ModelAndView mv = new ModelAndView();
            List<User> list = userServiceImpl.listUser();
            model.addAttribute("user-form", list);
            mv.setViewName("user-form");
            return mv;
        }

}


