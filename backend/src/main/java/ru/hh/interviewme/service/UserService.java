package ru.hh.interviewme.service;

import org.springframework.stereotype.Service;

import ru.hh.interviewme.entity.User;
import ru.hh.interviewme.entity.UserRole;
import ru.hh.interviewme.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public User saveUser(String name, String phone, String email) {
        User user = new User();
        user.setName(name);
        user.setPhone(phone);
        user.setEmail(email);
        user.setRole(UserRole.USER);
        userRepository.save(user);
        return user;
    }

    public User getUser(int id) {
        return userRepository.getOne(id);
    }

}
