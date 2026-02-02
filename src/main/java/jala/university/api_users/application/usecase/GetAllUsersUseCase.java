package jala.university.api_users.application.usecase;

import jala.university.api_users.application.port.UserRepository;
import jala.university.api_users.domain.model.User;
import java.util.List;

public final class GetAllUsersUseCase {

  private final UserRepository userRepository;
  public GetAllUsersUseCase(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  public List<User> execute(){
    return userRepository.findAll();
  }
}
