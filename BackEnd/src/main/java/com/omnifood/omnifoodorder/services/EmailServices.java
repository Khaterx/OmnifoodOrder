package com.omnifood.omnifoodorder.services;

import com.omnifood.omnifoodorder.dto.Mail;

public interface EmailServices {
    public void sendActivatedCodeByMail(Mail mail);
}
