package ir.mmghteam.springmvc.controller;

import ir.mmghteam.springmvc.model.User;
import ir.mmghteam.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Locale;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String userForm(Locale locale, Model model) {
        model.addAttribute("users", userService.list());
        return "editUsers";
    }

    @ModelAttribute("user")
    public User formBackingObject() {
        return new User();
    }

    @PostMapping("/addUser")
    public String saveUser(@ModelAttribute("user") @Valid User user,
                           BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("users", userService.list());
            return "editUsers";
        }

        userService.save(user);
        return "redirect:/";
    }
    @RequestMapping("/deleteUser")
    public String deleteUser(Long id, Model model) {
        userService.delete(id);
        return "redirect:/";
    }
    @GetMapping("/users/{id}/delete")
    public String deleteUser(@PathVariable Long id) {
        // delete user by id
        userService.deleteUserById(id);

        return "redirect:/";
    }
    @RequestMapping("/editUser")
    public String editUser(Long id, Model model) {
        model.addAttribute("user", userService.get(id));
        return "editUsers";
    }
    @RequestMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("users", userService.list());
            return "editUsers";
        }
        userService.update(user);
        return "redirect:/";
    }

}
