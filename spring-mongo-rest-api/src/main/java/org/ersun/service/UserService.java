package org.ersun.service;

import org.ersun.model.user.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    User insert(User user);

    List<User> findAll();

    User update(User user);

    void delete(String id);

    List<User> findByUserName(String userName);

    List<User> findAllByPage(Pageable pageable);

    List<User> getAllUsersByPetAge(short age);
}
