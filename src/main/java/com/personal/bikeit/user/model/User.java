package com.personal.bikeit.user.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

  private UUID id;
  private String name;

  public User(@JsonProperty("id") UUID id, @JsonProperty("name") String name) {
    this.id = id;
    this.name = name;
  }

  public User() {
  }

  public void setID(UUID id) {
    this.id = id;
  }

  public UUID getID() {
    return id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
