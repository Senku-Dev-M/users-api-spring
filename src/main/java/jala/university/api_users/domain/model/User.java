package jala.university.api_users.domain.model;

import jala.university.api_users.domain.exception.InvalidUserException;
import java.util.UUID;

public final class User {
  private final UUID id;
  private final String name;
  private final Email email;

  public User(String name, Email email) {
    if(isValid(name, email)) {
      this.id = UUID.randomUUID();
      this.name = name;
      this.email = email;
    } else {
      throw new InvalidUserException("Invalid user");
    }
  }

  public User(UUID id, String name, Email email) {
    if (id == null || !isValid(name, email)) {
      throw new InvalidUserException("Invalid user");
    }
    this.id = id;
    this.name = name;
    this.email = email;
  }

  private boolean isValid(String name, Email email) {
    return name != null && !name.isBlank() && email != null;
  }

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Email getEmail() {
    return email;
  }
}
