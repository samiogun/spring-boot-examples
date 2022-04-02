package org.ersun.repository;

import org.ersun.model.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User , String> {

    public List<User> findByUserName(String userName);

    public List<User> findByPetsAge(short age);

}
