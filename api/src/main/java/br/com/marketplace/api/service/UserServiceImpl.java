package br.com.marketplace.api.service;

import br.com.marketplace.api.model.UserInfo;
import br.com.marketplace.api.model.UserRole;
import br.com.marketplace.api.repository.UserRepository;
import br.com.marketplace.api.repository.UserRoleRepository;
import br.com.marketplace.api.request.UserRequest;
import br.com.marketplace.api.response.UserResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public UserResponse saveUser(UserRequest userRequest) {
        // Check if user already exists
        UserInfo existingUser = userRepository.findByUsername(userRequest.getUsername());

        if (existingUser != null) {
            throw new RuntimeException("User already exists with username: " + userRequest.getUsername());
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = userRequest.getPassword();
        String encodedPassword = encoder.encode(rawPassword);

        // Convert UserRequest to User entity
        UserInfo user = new UserInfo();
        user.setUsername(userRequest.getUsername());
        user.setPassword(encodedPassword);

        Set<UserRole> roles = new HashSet<>();
        for (UserRole role : userRequest.getRoles()) {
            UserRole userRole = userRoleRepository.findByName(role.getName());
            if (userRole == null) {
                userRole = new UserRole();
                userRole.setName(role.getName());
                userRole = userRoleRepository.save(userRole);
            }
            roles.add(userRole);
        }
        user.setRoles(roles);

        // Save the user to the database
        user = userRepository.save(user);

        // Convert User entity to UserResponse
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setUsername(user.getUsername());
        userResponse.setRoles(user.getRoles());

        return userResponse;
    }

    @Override
    public UserResponse getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetail = (UserDetails) authentication.getPrincipal();
        String usernameFromAccessToken = userDetail.getUsername();
        UserInfo user = userRepository.findByUsername(usernameFromAccessToken);
        UserResponse userResponse = modelMapper.map(user, UserResponse.class);
        return userResponse;
    }

    @Override
    public List<UserResponse> getAllUser() {
        List<UserInfo> users = (List<UserInfo>) userRepository.findAll();
        Type setOfDTOsType = new TypeToken<List<UserResponse>>(){}.getType();
        List<UserResponse> userResponses = modelMapper.map(users, setOfDTOsType);
        return userResponses;
    }


}
