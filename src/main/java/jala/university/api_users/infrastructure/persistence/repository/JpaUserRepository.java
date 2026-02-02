package jala.university.api_users.infrastructure.persistence.repository;

import jala.university.api_users.application.port.UserRepository;
import jala.university.api_users.domain.model.Email;
import jala.university.api_users.domain.model.User;
import jala.university.api_users.infrastructure.persistence.entity.UserEntity;
import jala.university.api_users.infrastructure.persistence.mapper.UserMapper;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class JpaUserRepository implements UserRepository {

  private final SpringDataUserRepository springDataUserRepository;

  public JpaUserRepository(SpringDataUserRepository springDataUserRepository) {
    this.springDataUserRepository = springDataUserRepository;
  }

  @Override
  public User save(User user) {
    UserEntity entity = UserMapper.toEntity(user);
    UserEntity saved = springDataUserRepository.save(entity);
    return UserMapper.toDomain(saved);
  }

  @Override
  public Optional<User> findById(UUID id) {
    return springDataUserRepository
        .findById(id)
        .map(UserMapper::toDomain);
  }

  @Override
  public Optional<User> findByEmail(Email email) {
    return springDataUserRepository
        .findByEmail(email.getEmail())
        .map(UserMapper::toDomain);
  }

  @Override
  public List<User> findAll() {
    return springDataUserRepository
        .findAll()
        .stream()
        .map(UserMapper::toDomain)
        .collect(Collectors.toList());
  }

  @Override
  public void deleteById(UUID id) {
    springDataUserRepository.deleteById(id);
  }
}
