package com.personal.bikeit.user.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.personal.bikeit.user.model.User;

public interface UserDAO {

  User add(User user);

  Optional<User> getByID(UUID id);

  List<User> getAll();

  User update(UUID id, User user);

  boolean delete(UUID id);
}
