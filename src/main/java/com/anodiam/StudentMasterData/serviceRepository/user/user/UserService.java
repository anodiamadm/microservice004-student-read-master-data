package com.anodiam.StudentMasterData.serviceRepository.user.user;

import com.anodiam.StudentMasterData.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);
}
