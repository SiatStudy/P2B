package com.example.p2b.controller;

import com.example.p2b.domain.Email;
import com.example.p2b.dto.MailDTO;
import com.example.p2b.repository.EmailRepository;
import com.example.p2b.service.EmailService;
import com.example.p2b.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/mail")
public class MailController {

    private final EmailService emailService;
    private final UserService userService;

    @GetMapping("/send")
    public String main() {
        return "SendMail.html";
    }


    @PostMapping("/send")
    public @ResponseBody ResponseEntity<Map<String, Boolean>> sendMail(@Validated
                                                                       @RequestBody MailDTO mailDto) {
        System.out.println("sendMail 실행 확인");
        System.out.println("address : " + mailDto.getAddress());
        System.out.println("title : " + mailDto.getTitle());
        System.out.println("content : " + mailDto.getContent());

        Map<String, Boolean> map1 = new HashMap<>();
        try {
            map1.put("result", true);
            emailService.sendSimpleMessage(mailDto);
        }catch (Exception e){
            map1.put("result", false);
            e.printStackTrace();
        }

//        테스트용 코드
//        map1.put("result", "true");
//        map1.put("address", mailDto.getAddress());
//        map1.put("title", mailDto.getTitle());
//        map1.put("content", mailDto.getContent());
        // return Json to browser
        ResponseEntity<Map<String, Boolean>> entity =
                new ResponseEntity<>(map1, HttpStatus.OK);
        return entity;
//        return mailDto;
    }

//    @PostMapping("/check")
//    public ResponseEntity<Map> checkCode(@RequestBody("code") String code){
//
//        return new ResponseEntity<Map>()
//    }

}
