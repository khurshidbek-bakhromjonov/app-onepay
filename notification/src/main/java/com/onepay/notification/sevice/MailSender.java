package com.onepay.notification.sevice;

import com.onepay.notification.dto.UserDTO;

public interface MailSender {

    void greetingEmail(UserDTO userDTO);
    void changePasswordEmail(UserDTO userDTO);
    void dailyEmail(UserDTO userDTO);
}
