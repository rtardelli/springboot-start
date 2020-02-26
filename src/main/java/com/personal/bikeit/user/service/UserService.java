package com.personal.bikeit.user.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.personal.bikeit.user.dao.UserDAO;
import com.personal.bikeit.user.model.User;

/**
 * Serviço de manipulação dos usuários do sistema. Toda a lógica e validação ficará nessa camada.
 */
@Service
public class UserService {

  private final UserDAO userDAO;

  @Autowired
  public UserService(@Qualifier("fakeDao") UserDAO userDAO) {
    this.userDAO = userDAO;
  }

  public User add(User user) {
    user.setID(UUID.randomUUID());
    return userDAO.add(user);
  }

  public List<User> getAll() {
    return userDAO.getAll();
  }

  public Optional<User> getByID(String id) {
    UUID userID = UUID.fromString(id);
    return userDAO.getByID(userID);
  }

  public User update(String id, User user) {
    UUID userID = UUID.fromString(id);
    return userDAO.update(userID, user);
  }

  public boolean delete(String id) {
    UUID userID = UUID.fromString(id);
    return userDAO.delete(userID);
  }
}
