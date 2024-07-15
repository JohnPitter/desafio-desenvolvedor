package br.com.marketplace.api.service;

import br.com.marketplace.api.request.UserRequest;
import br.com.marketplace.api.response.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse saveUser(UserRequest userRequest);
    UserResponse getUser();
    List<UserResponse> getAllUser();
}
