package org.ersun.service;

import lombok.RequiredArgsConstructor;
import org.ersun.model.user.User;
import org.ersun.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User insert(User user) {
        return userRepository.insert(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public List<User> findAllByPage(Pageable pageable) {
        Page<User> userPage = userRepository.findAll(pageable);
        return userPage.getContent();
//        return userRepository.findAll(pageable).stream().collect(Collectors.toList());
    }

    @Override
    public List<User> getAllUsersByPetAge(short age) {
        return userRepository.findByPetsAge(age);
    }

}
