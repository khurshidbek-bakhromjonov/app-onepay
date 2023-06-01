package com.onepay.notification.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTO {

    String firstName;
    String lastName;
    String email;
    LocalDateTime joinedAt;
}
