package com.onepay.notification.sevice;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@RequiredArgsConstructor
public abstract class AbstractMailSender implements MailSender {

    private final JavaMailSender javaMailSender;
    protected String title;
    protected String message;

    @Value("${server.port}")
    protected String serverPort;

    @Value("${spring.mail.username}")
    private String username;

    protected void sendWithMime(String emailTo, String subject, String message) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

            mimeMessageHelper.setFrom(username);
            mimeMessageHelper.setTo(emailTo);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(message, true);

            new Thread(() -> javaMailSender.send(mimeMessage));
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
