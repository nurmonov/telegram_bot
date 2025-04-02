package com.uz.telegrambot.service;

import com.uz.telegrambot.dto.UserDTO;
import com.uz.telegrambot.entity.User;
import com.uz.telegrambot.mapper.UserMapper;
import com.uz.telegrambot.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.userMapper = UserMapper.INSTANCE;
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toUserDTO)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(userMapper::toUserDTO).orElse(null);
    }

    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.toUser(userDTO);
        user = userRepository.save(user);
        return userMapper.toUserDTO(user);
    }

    public UserDTO updateUser(Integer id, UserDTO userDTO) {
        if (!userRepository.existsById(id)) {
            return null;
        }
        User user = userMapper.toUser(userDTO);
        user.setId(id);
        user = userRepository.save(user);
        return userMapper.toUserDTO(user);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}


