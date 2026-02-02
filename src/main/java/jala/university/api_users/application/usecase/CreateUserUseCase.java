package jala.university.api_users.application.usecase;

import jala.university.api_users.application.port.UserRepository;
import jala.university.api_users.domain.model.Email;
import jala.university.api_users.domain.model.User;

public final class CreateUserUseCase {

  private final UserRepository userRepository;

  public CreateUserUseCase(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User execute(String name, String email){
    Email  emailObj = new Email(email);
    User userObj = new User(name, emailObj);
    return userRepository.save(userObj);
  }

}
