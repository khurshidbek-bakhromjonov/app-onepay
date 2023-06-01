package com.onepay.notification.controller;

import com.onepay.notification.enums.EmailType;
import com.onepay.notification.sevice.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping("/{userId}")
    public ResponseEntity<String> notificateUser(@PathVariable("userId") Integer userId,
                                                 @RequestParam("type") EmailType type) {
        notificationService.sendNotification(userId, type);
        return ResponseEntity.ok("Send notification successfully");
    }
}
