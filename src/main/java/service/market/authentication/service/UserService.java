package service.market.authentication.service;

import service.market.authentication.dto.CreateUserDTO;
import service.market.authentication.dto.UpdateUserDTO;
import service.market.authentication.entity.User;

public interface UserService {
    User createUser(CreateUserDTO user);

    User getUserDetail(Long id);

    User updateUser(UpdateUserDTO user);

    User deleteUser(Long id);
}
