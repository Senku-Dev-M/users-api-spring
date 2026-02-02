package jala.university.api_users.domain.exception;

public class InvalidEmailException extends RuntimeException {
  public InvalidEmailException(String message) {
        super(message);
    }
}
