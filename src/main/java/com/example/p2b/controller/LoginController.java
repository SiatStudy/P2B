package com.example.p2b.controller;

import com.example.p2b.domain.User;
import com.example.p2b.dto.LoginDTO;
import com.example.p2b.exception.UserNotFoundException;
import com.example.p2b.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }
    @PostMapping("/duple/id")
    public @ResponseBody boolean idCheck(@RequestBody String username) {
        return !userService.idCheck(username);
    }

    @PostMapping("/duple/email")
    public @ResponseBody boolean emailCheck(@RequestBody String userEmail) {
        return !userService.emailCheck(userEmail);
    }

    @PostMapping("/loginTest")
    public ResponseEntity<Map<String, Object>> loginTest(@RequestBody LoginDTO loginDTO) {
        System.out.println("id : " + loginDTO.getUsername());
        System.out.println("pw : " + loginDTO.getUserpassword());

        User user = userService.findUser(loginDTO.getUsername());

        System.out.println("user : " + user);

        Map<String, Object> response = new HashMap<>();

        if (user != null && user.getUserPassword().equals(loginDTO.getUserpassword())) {
            response.put("message", "Login successful");
            response.put("userId", user.getId());
            response.put("isValid", true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("message", "Login failed");
            response.put("isValid", false);
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }
    }
    @PostMapping("/search/id")
    public ResponseEntity<Map> findId(@RequestParam("userEmail") String userEmail) {
        // 서비스 메소드 호출
        Optional<String> optionalUsername = userService.findIdByEmail(userEmail);

        if (optionalUsername.isPresent()) {
            String username = optionalUsername.get();
            String message = "찾으신 아이디는: " + username;
            System.out.println("id : " + username);
            System.out.println("find Id 값 : " + message);
            return new ResponseEntity<>(Map.of("userid", username), HttpStatus.OK);
        } else {
            String message = "해당 아이디를 찾을 수 없습니다.";
            System.out.println("find Id 값 : " + message);
            return new ResponseEntity<>(Map.of("messege", "아이디를 찾을 수 없습니다."), HttpStatus.OK);
        }
    }

//    @PostMapping("/search/password")
//    public ResponseEntity<Map> findPassword(@RequestParam("username") String username, @RequestParam("useremail") String userEmail, Model model) {
//        try {
//            //서비스 메소드 호출 후, 새 비밀번호 변경 페이지로 이동
//            String result = userService.findUserByUsernameAndEmail(username, userEmail);
//            model.addAttribute("username", result);
//        } catch (UserNotFoundException e) {
//            // 이메일이나 아이디가 존재하지 않을 경우 에러 메시지를 반환
//            model.addAttribute("errorMessage", e.getMessage());
//        }
//    }
}
