package jala.university.api_users.infrastructure.config;

import jala.university.api_users.application.port.UserRepository;
import jala.university.api_users.application.usecase.CreateUserUseCase;
import jala.university.api_users.application.usecase.DeleteUserUseCase;
import jala.university.api_users.application.usecase.GetAllUsersUseCase;
import jala.university.api_users.application.usecase.GetUserByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

  @Bean
  public CreateUserUseCase createUserUseCase(UserRepository userRepository) {
    return new CreateUserUseCase(userRepository);
  }

  @Bean
  public GetUserByIdUseCase getUserByIdUseCase(UserRepository userRepository) {
    return new GetUserByIdUseCase(userRepository);
  }

  @Bean
  public GetAllUsersUseCase getAllUsersUseCase(UserRepository userRepository) {
    return new GetAllUsersUseCase(userRepository);
  }

  @Bean
  public DeleteUserUseCase deleteUserUseCase(UserRepository userRepository) {
    return new DeleteUserUseCase(userRepository);
  }
}
