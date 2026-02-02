package jala.university.api_users.application.port;

import jala.university.api_users.domain.model.Email;
import jala.university.api_users.domain.model.User;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

  User save(User user);
  Optional<User> findById(UUID id);
  Optional<User> findByEmail(Email email);
  List<User> findAll();
  void deleteById(UUID id);

}
