package com.onepay.balance.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTO {

    Integer id;
    String firstName;
    String lastName;
    String email;
    String password;
    BigDecimal balance;
    LocalDateTime joinedAt;
}
