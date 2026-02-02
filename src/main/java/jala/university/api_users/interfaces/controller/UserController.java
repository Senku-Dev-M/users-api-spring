package jala.university.api_users.interfaces.controller;

import jala.university.api_users.application.usecase.CreateUserUseCase;
import jala.university.api_users.application.usecase.DeleteUserUseCase;
import jala.university.api_users.application.usecase.GetAllUsersUseCase;
import jala.university.api_users.application.usecase.GetUserByIdUseCase;
import jala.university.api_users.domain.model.User;
import jala.university.api_users.interfaces.dto.UserRequestDTO;
import jala.university.api_users.interfaces.dto.UserResponseDTO;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  private final CreateUserUseCase createUserUseCase;
  private final GetUserByIdUseCase  getUserByIdUseCase;
  private final GetAllUsersUseCase getAllUsersUseCase;
  private final DeleteUserUseCase deleteUserUseCase;

  public UserController(CreateUserUseCase createUserUseCase,
      GetUserByIdUseCase getUserByIdUseCase,
      GetAllUsersUseCase getAllUsersUseCase,
      DeleteUserUseCase deleteUserUseCase) {
    this.createUserUseCase = createUserUseCase;
    this.getUserByIdUseCase = getUserByIdUseCase;
    this.getAllUsersUseCase = getAllUsersUseCase;
    this.deleteUserUseCase = deleteUserUseCase;
  }

  @PostMapping
  public ResponseEntity<UserResponseDTO> create(
      @Valid @RequestBody UserRequestDTO request) {

    User user = createUserUseCase.execute(
        request.getName(),
        request.getEmail()
    );

    UserResponseDTO response = new UserResponseDTO();
    response.setId(user.getId());
    response.setName(user.getName());
    response.setEmail(user.getEmail().getEmail());

    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(response);
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserResponseDTO> getById(
      @PathVariable UUID id) {

    return getUserByIdUseCase.execute(id)
        .map(user -> {
          UserResponseDTO response = new UserResponseDTO();
          response.setId(user.getId());
          response.setName(user.getName());
          response.setEmail(user.getEmail().getEmail());
          return ResponseEntity.ok(response);
        })
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @GetMapping
  public ResponseEntity<List<UserResponseDTO>> getAll() {

    List<UserResponseDTO> response = getAllUsersUseCase.execute()
        .stream()
        .map(user -> {
          UserResponseDTO dto = new UserResponseDTO();
          dto.setId(user.getId());
          dto.setName(user.getName());
          dto.setEmail(user.getEmail().getEmail());
          return dto;
        })
        .collect(Collectors.toList());

    return ResponseEntity.ok(response);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable  UUID id) {
    deleteUserUseCase.execute(id);
    return ResponseEntity.noContent().build();
  }
}
