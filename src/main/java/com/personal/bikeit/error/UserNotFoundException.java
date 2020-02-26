package com.personal.bikeit.error;

public class UserNotFoundException extends RuntimeException {

  private String userID;

  public UserNotFoundException(String userID) {
    super();
    this.userID = userID;
  }

  public String getDescription() {
    return "Usuário com o identificador " + userID + " não foi encontrado";
  }

  @Override
  public String getMessage() {
    return "User with id " + userID + " was not found";
  }
}
