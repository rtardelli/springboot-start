package com.personal.bikeit.user.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import com.personal.bikeit.user.model.User;

@Repository("fakeDao")
public class FakeUserDataAccess implements UserDAO {

  private List<User> DB = new ArrayList<>();

  @Override
  public User add(User user) {
    DB.add(user);
    return user;
  }

  @Override
  public Optional<User> getByID(UUID id) {
    return DB.stream().filter(u -> u.getID().equals(id)).findFirst();
  }

  @Override
  public List<User> getAll() {
    return Collections.unmodifiableList(DB);
  }

  @Override
  public User update(UUID id, User user) {
    Optional<User> u = getByID(id);
    if(!u.isPresent()) {
      return u.get();
    }
    return null;
  }

  @Override
  public boolean delete(UUID id) {
    Optional<User> u = getByID(id);
    return DB.remove(u);
  }
}
