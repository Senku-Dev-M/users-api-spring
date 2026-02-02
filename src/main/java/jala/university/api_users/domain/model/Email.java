package jala.university.api_users.domain.model;

import jala.university.api_users.domain.exception.InvalidEmailException;

public final class Email {
  private final String email;
  private static final String REGEX_EMAIL = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,7}$";

  public Email(String email) throws InvalidEmailException {
    if(isValid(email))
      this.email = email;
    else
      throw new InvalidEmailException("This email not contain format");
  }

  private boolean isValid(String email) {
    return email != null && email.matches(REGEX_EMAIL);
  }

  public String getEmail() {
    return email;
  }
}
