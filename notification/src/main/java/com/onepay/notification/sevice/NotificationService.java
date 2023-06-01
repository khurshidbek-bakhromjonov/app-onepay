package com.onepay.notification.sevice;

import com.onepay.notification.enums.EmailType;

@FunctionalInterface
public interface NotificationService {

    void sendNotification(long userId, EmailType type);
}
