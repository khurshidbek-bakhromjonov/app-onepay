package com.onepay.user.service;

import com.onepay.user.dto.UserDTO;
import com.onepay.user.entity.User;
import com.onepay.user.exception.UserNotFoundException;
import com.onepay.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Override
    public void addUser(UserDTO userDTO) {
        User user = User.builder()
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .password(userDTO.getPassword())
                .joinedAt(LocalDateTime.now())
                .build();

        userRepository.saveAndFlush(user);
        log.info("Add new user. Id: {}", user.getId());
    }

    @Override
    public void deleteById(Integer id) {
        User user = this.getUserById(id);
        userRepository.delete(user);
        log.info("Delete user. Id: {}", id);
    }

    @Override
    public void updateById(Integer id, UserDTO userDTO) {
        User user = this.getUserById(id);

        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        userRepository.save(user);
        log.info("Update user. Id: {}", id);
    }

    @Override
    public void updateBalanceById(Integer id, BigDecimal balance) {
        User user = this.getUserById(id);
        user.setBalance(balance);

        userRepository.save(user);
        log.info("Change balance. User id: {}", id);
    }
}
