package com.omnifood.omnifoodorder.services;

import com.omnifood.omnifoodorder.dto.Mail;
import com.omnifood.omnifoodorder.utils.UniqueCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailServicesImpl implements EmailServices {
    private JavaMailSender javaMailSender;
    private UniqueCode activeCode = new UniqueCode();

    @Autowired
    public EmailServicesImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    @Async
    public void sendActivatedCodeByMail(Mail mail) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("91095a703f2240");
        simpleMailMessage.setTo(mail.getTo());
        simpleMailMessage.setSubject("Verify your email address by Code Active below.");
        simpleMailMessage.setText(activeCode.getUniqueCode());
        javaMailSender.send(simpleMailMessage);
    }
}
