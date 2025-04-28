package service.market.authentication.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import service.market.authentication.dto.CreateUserDTO;
import service.market.authentication.dto.RegisterRequest;
import service.market.authentication.dto.UpdateUserDTO;
import service.market.authentication.entity.User;

public interface UserService {
    User createUser(CreateUserDTO user);

    User createUser(RegisterRequest registerRequest);

    User getUserDetail(Long id);

    User updateUser(UpdateUserDTO user);

    User deleteUser(Long id);

    boolean existsByUsername(String username);
}
