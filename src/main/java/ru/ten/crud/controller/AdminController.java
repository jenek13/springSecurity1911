package ru.ten.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.ten.crud.model.User;
import ru.ten.crud.service.UserService;

import java.sql.SQLException;
import java.util.List;

@Controller("admin")
public class AdminController {

    @Autowired
    private UserService userService;

    //получить список юзеров
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView showUserList() {
        List<User> listUsers = userService.listUser();
        ModelAndView modelAndView = new ModelAndView("admin");
        modelAndView.addObject("admin", listUsers);
        return modelAndView;
    }

    //добавить юзера
    @RequestMapping(value = "/admin/users", method = RequestMethod.POST)
    public String addUser( @RequestParam("name") String name, @RequestParam("age") int age) {
        if (name.isEmpty()) {
            return "redirect:/user-form";
        }
        userService.insertUser(new User(name,age));
        return "redirect:/admin";
    }

    //открыть форму где заолняегь данные для нвого юзера
    @RequestMapping(value = "/admin/users", method = RequestMethod.GET)
    public ModelAndView addUser() {
        ModelAndView model = new ModelAndView("user-form");
        return model;
    }


    @RequestMapping(value = "/admin/users/delete", method = RequestMethod.GET)
    public String deleteUser(@RequestParam("id") int id) throws SQLException {
        userService.deleteUser(id);
        return "redirect:/admin";
    }


}
