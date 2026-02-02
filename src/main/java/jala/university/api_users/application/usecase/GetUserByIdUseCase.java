package jala.university.api_users.application.usecase;

import jala.university.api_users.application.port.UserRepository;
import jala.university.api_users.domain.model.User;
import java.util.Optional;
import java.util.UUID;

public final class GetUserByIdUseCase {

  private final UserRepository userRepository;

  public GetUserByIdUseCase(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public Optional<User> execute(UUID id){
    return userRepository.findById(id);
  }

}
