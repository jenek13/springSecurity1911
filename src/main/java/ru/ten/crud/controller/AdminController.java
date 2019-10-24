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

    //удалить юзера
    @RequestMapping(value = "/admin/users/delete", method = RequestMethod.GET)
    public String deleteUser(@RequestParam("id") int id) throws SQLException {

        userService.deleteUser(id);
        return "redirect:/admin";
    }

    //попасть на страницу куда вводить данные для внесения изменений на конкретном выбранном юзере по айдишке на которую кликнули
    @RequestMapping(value = "/admin/users/edit", method = RequestMethod.GET)
    public ModelAndView editUser(@RequestParam("id") int id) throws SQLException {
        User user = userService.selectUser(id);
        ModelAndView model = new ModelAndView("edit");
        if (user != null) {
            model.addObject("user", user);
            return model;
        }
        model.addObject(new User());
        return model;
    }

    //внести изменения и вернуть на старницу с юзерами с уже готовыми измениями
    @RequestMapping(value = "/admin/users/edit", method = RequestMethod.POST)
    public String editUser(@RequestParam("id") int id,
                           @RequestParam("name") String name,
                           @RequestParam("age") int age) throws SQLException {
        if (name.isEmpty() ) {
            return "redirect:/edit?id=" + id;
        }
        userService.updateUser(new User(id, name, age));
        return "redirect:/admin";
    }

}
