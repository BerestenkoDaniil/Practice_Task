package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(String username, String email) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setCreatedOn(LocalDateTime.now());
        return userRepository.save(user);
    }

    public List<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable).getContent();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
