package com.anodiam.StudentMasterData.serviceRepository.userProfile.user;

import com.anodiam.StudentMasterData.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);
    User save(User user);
    User GetSingleUser();
}
