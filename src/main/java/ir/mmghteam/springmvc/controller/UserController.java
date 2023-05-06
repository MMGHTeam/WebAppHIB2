package ir.mmghteam.springmvc.controller;

import ir.mmghteam.springmvc.model.User;
import ir.mmghteam.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String userForm(Model model) {
        model.addAttribute("users", userService.list());
        return "editUsers";
    }

    @ModelAttribute("user")
    public User formBackingObject(@PathVariable(required = false) Long id) {
        if (id != null) {
            return (User) userService.getById(id);
        } else {
            return new User();
        }
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
    @PostMapping("/users/{id}/addUser")
    public String saveUserAfterUpdate(@ModelAttribute("user") @Valid User user,
                                      BindingResult result, Model model){
        if (result.hasErrors()) {
            model.addAttribute("users", userService.list());
            return "editUsers";
        }

        userService.update(user);
        return "redirect:/";

    }

    @RequestMapping("/deleteUser")
    public String deleteUser(Long id) {
        userService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/users/{id}/delete")
    public String deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:/";
    }

    @GetMapping("/users/{id}/update")
    public String updateUserForm(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "editUsers";
    }

    @PostMapping("/users/{id}/update")
    public String updateUser(@PathVariable Long id, @ModelAttribute("user") @Valid User user,
                             BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("users", userService.list());
            return "editUsers";
        }

        user.setId(id);
        userService.save(user);
        return "redirect:/";
    }

}
