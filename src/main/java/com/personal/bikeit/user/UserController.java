package com.personal.bikeit.user;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.personal.bikeit.error.UserNotFoundException;
import com.personal.bikeit.user.model.User;
import com.personal.bikeit.user.service.UserService;

@RequestMapping("api/v1/users")
@RestController
public class UserController  {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public @ResponseBody
  ResponseEntity<List<User>> getAll() {
    return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public @ResponseBody ResponseEntity<User> getByID(@PathVariable String id) {
    Optional<User> optionalUser = userService.getByID(id);
    if(optionalUser.isPresent()) {
      return new ResponseEntity<>(optionalUser.get(), HttpStatus.OK);
    } else {
      throw new UserNotFoundException(id);
    }
  }

  @PostMapping
  public @ResponseBody ResponseEntity<User> add(User user) {
    return new ResponseEntity<>(userService.add(user), HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public @ResponseBody ResponseEntity<User> update(@PathVariable String id, User user) {
    return new ResponseEntity<>(userService.update(id, user), HttpStatus.OK);
  }

  /*
  * {
 "apierror": {
   "status": "BAD_REQUEST",
   "timestamp": "18-07-2017 06:49:25",
   "message": "Validation errors",
   "subErrors": [
     {
       "object": "bird",
       "field": "mass",
       "rejectedValue": 999999,
       "message": "must be less or equal to 104000"
     }
   ]
 }
}
  * */
  @PostMapping
  public @ResponseBody ResponseEntity<User> post(@RequestBody User user) {
    // TODO: Reimplementar chamando service
    return new ResponseEntity<>(user, HttpStatus.OK);
  }

  @PutMapping
  public @ResponseBody ResponseEntity<User> put(@RequestBody User user) {
    return new ResponseEntity<>(user, HttpStatus.OK);
  }

  @DeleteMapping
  public @ResponseBody ResponseEntity<User> delete(@RequestBody User user) {
    return new ResponseEntity<>(user, HttpStatus.OK);
  }

}
