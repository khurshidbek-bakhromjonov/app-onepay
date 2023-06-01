package com.onepay.user.service;

import com.onepay.user.dto.UserDTO;
import com.onepay.user.entity.User;

import java.math.BigDecimal;
import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getUserById(Integer id);
    void addUser(UserDTO user);
    void deleteById(Integer id);
    void updateById(Integer id, UserDTO updatedUser);
    void updateBalanceById(Integer id, BigDecimal balance);
}
