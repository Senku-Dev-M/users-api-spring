package jala.university.api_users.application.usecase;

import jala.university.api_users.application.port.UserRepository;
import java.util.UUID;

public final class DeleteUserUseCase {

  private final UserRepository userRepository;

  public DeleteUserUseCase(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  public void execute(UUID id){
    userRepository.deleteById(id);
  }

}
