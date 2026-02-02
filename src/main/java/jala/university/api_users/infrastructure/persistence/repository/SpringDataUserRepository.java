package jala.university.api_users.infrastructure.persistence.repository;

import jala.university.api_users.infrastructure.persistence.entity.UserEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

interface SpringDataUserRepository
    extends JpaRepository<UserEntity, UUID> {

  Optional<UserEntity> findByEmail(String email);
}