package org.ersun.api;

import lombok.RequiredArgsConstructor;
import org.ersun.model.user.User;
import org.ersun.service.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = "/user")
@RequiredArgsConstructor
public class UserApi {

    private final UserService userService;

    @PostMapping(path = "/")
    public ResponseEntity<User> addUser(@RequestBody User user){

        return new ResponseEntity<>(userService.insert(user),CREATED);

    }

    @GetMapping(path = "/")
    public ResponseEntity<List<User>> getAllUsers(){

        return new ResponseEntity<>(userService.findAll(),OK);

    }

    @PutMapping(path = "/")
    public ResponseEntity<User> updateUser(@RequestBody User user){

        return new ResponseEntity<>(userService.update(user), OK);


    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable(name = "id") String id){

        userService.delete(id);
        return new ResponseEntity<>(OK);

    }

    @GetMapping("/{username}")
    public ResponseEntity<List<User>> getUsersByName(@PathVariable(value = "username") String username){

//        return ResponseEntity.ok(userService.findByUserName(username));
        return new ResponseEntity<>(userService.findByUserName(username), OK);

    }

    @GetMapping("/page")
    public ResponseEntity<List<User>> getAllUsersByPage(Pageable pageable){

        return new ResponseEntity<>(userService.findAllByPage(pageable),OK);

    }

    @GetMapping("/petage")
    public ResponseEntity<List<User>> getAllUsersByPetAge(@RequestParam(name = "age") short age){

        return new ResponseEntity<>(userService.getAllUsersByPetAge(age),OK);

    }

}
