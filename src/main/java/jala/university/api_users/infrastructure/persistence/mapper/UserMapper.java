package jala.university.api_users.infrastructure.persistence.mapper;

import jala.university.api_users.domain.model.Email;
import jala.university.api_users.domain.model.User;
import jala.university.api_users.infrastructure.persistence.entity.UserEntity;

public final class UserMapper {

  public static UserEntity toEntity(User user){
    UserEntity entity = new UserEntity();
    entity.setId(user.getId());
    entity.setName(user.getName());
    entity.setEmail((user.getEmail().getEmail()));

    return entity;
  }

  public static User toDomain (UserEntity entity){
    Email email = new Email(entity.getEmail());
    User user = new User(entity.getId(), entity.getName(), email);
    return user;
  }

}
