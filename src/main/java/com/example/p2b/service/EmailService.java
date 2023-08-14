package com.example.p2b.service;

import com.example.p2b.domain.Email;
import com.example.p2b.dto.MailDTO;
import com.example.p2b.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class EmailService {

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);
    private JavaMailSender mailSender;
    private final EmailRepository emailRepository;

    // 생성자 주입을 이용한 의존성 주입
    public EmailService(JavaMailSender mailSender, EmailRepository emailRepository) {
        this.mailSender = mailSender;
        this.emailRepository = emailRepository;
    }


    @Transactional
    public void sendSimpleMessage(MailDTO mailDto) {
        int verificationCode = (int) Math.floor(100000 + Math.random() * 900000);

        try {
            System.out.println("------------ sendmail 시작---------------------");
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("siatproject123@gmail.com");
            message.setTo(mailDto.getUseremail());
            message.setSubject("[TODOS] 회원 가입 이메일 인증");
            message.setText("회원 가입을 위한 인증 코드는 " + verificationCode + " 입니다.");
            mailSender.send(message);

            Email email = new Email();
            email.setVrAuthCode(verificationCode);

            // 이메일 인증 시작시간을 현재 시간으로 설정
            LocalDateTime vrCreate = LocalDateTime.now();
            email.setVrCreate(vrCreate);

            // 이메일 인증 종료시간을 시작시간 기준 3분 후로 설정
            LocalDateTime vrExpire = vrCreate.plusMinutes(3);
            email.setVrExpire(vrExpire);

            email.setUsername(mailDto.getUsername());

            emailRepository.save(email);
        } catch (Exception e) {
            logger.error("sendSimpleMessage 메서드에서 오류 발생", e);
        }
    }

    @Transactional
    public void email(){
        Email email = new Email();

        // 이메일 인증 시작시간을 현재 시간으로 설정
        LocalDateTime vrCreate = LocalDateTime.now();
        email.setVrCreate(vrCreate);

        // 이메일 인증 종료시간을 시작시간 기준 3분 후로 설정
        LocalDateTime vrExpire = vrCreate.plusMinutes(3);
        email.setVrExpire(vrExpire);
    }

    public Email findUser(String username){
        Email email = emailRepository.findByUsername(username);
        return email;
    }
}
