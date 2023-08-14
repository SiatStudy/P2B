package com.example.p2b.controller;

import com.example.p2b.dto.UserDTO;
import com.example.p2b.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<Boolean> signUp(@RequestBody UserDTO userDTO) {
        System.out.println("-----------userDTO username : " + userDTO.getUsername());
        System.out.println("-----------userDTO useremail : " + userDTO.getUseremail());
        System.out.println("-----------userDTO usernickname : " + userDTO.getUsernickname());
        userService.signUp(userDTO);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping("/main")
    public String mainPage(HttpSession session, Model model) {
        String sessionId = session.getId();
        model.addAttribute("sessionId", sessionId);
        return "main";
    }


    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model) {
        UserDTO userDTO = userService.findById(id);
        model.addAttribute("user", userDTO);
        return "detail";
    }

    @GetMapping("/update")
    public String updateForm(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String myEmail = authentication.getName();
        UserDTO userDTO = userService.updateForm(myEmail);
        model.addAttribute("updateUser", userDTO);
        return "update";
    }

    @PatchMapping("/info")
    public String update(@ModelAttribute UserDTO userDTO) {
        userService.update(userDTO);
        return "redirect:/users/" + userDTO.getId();
    }

    @DeleteMapping("/info")
    public String deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return "redirect:/users/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "index";
    }

    @PostMapping("/changePassword")
    public String changePassword(@RequestParam("username") String username, @RequestParam("newPassword") String newPassword) {
        userService.changePassword(username, newPassword);
        return "redirect:/"; // index.html로 리다이렉트
    }
}
