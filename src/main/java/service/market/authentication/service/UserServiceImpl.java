package service.market.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import service.market.authentication.dto.CreateUserDTO;
import service.market.authentication.dto.RegisterRequest;
import service.market.authentication.dto.UpdateUserDTO;
import service.market.authentication.entity.User;
import service.market.authentication.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User createUser(CreateUserDTO user) {
        User.UserBuilder newUser = User.builder();
        newUser.firstName(user.getFirstName())
                .username(user.getUsername())
                .password(passwordEncoder.encode(user.getPassword()));
        if (user.getFirstName() != null) {
            newUser.firstName(user.getFirstName());
        }
        if (user.getFullName() != null) {
            newUser.fullName(user.getFullName());
        }
        return this.userRepository.save(newUser.build());
    }

    @Override
    public User createUser(RegisterRequest registerRequest) {
        User.UserBuilder newUser = User.builder();
        newUser.username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()));
        if (registerRequest.getFirstName() != null) {
            newUser.firstName(registerRequest.getFirstName());
        }
        if (registerRequest.getFullName() != null) {
            newUser.fullName(registerRequest.getFullName());
        }
        return this.userRepository.save(newUser.build());
    }

    @Override
    public User getUserDetail(Long id) {
        User user = this.userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return User.builder()
                .id(user.getId())
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .fullName(user.getFullName())
                .build();
    }

    @Override
    public User updateUser(UpdateUserDTO user) {
        return null;
    }

    @Override
    public User deleteUser(Long id) {
        User user = this.userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        this.userRepository.deleteById(id);
        return user;
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
}
