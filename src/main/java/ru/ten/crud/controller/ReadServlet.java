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
@RequestMapping("/admin")
public class ReadServlet {

    @Autowired
    UserServiceImpl userServiceImpl;

        @RequestMapping(value = {"/admin"}, method = RequestMethod.GET)
        public ModelAndView read(ModelMap model) {
            ModelAndView mv = new ModelAndView();
            List<User> list = userServiceImpl.listUser();
            model.addAttribute("user-list", list);
            mv.setViewName("user-list");
            return mv;
        }
}
