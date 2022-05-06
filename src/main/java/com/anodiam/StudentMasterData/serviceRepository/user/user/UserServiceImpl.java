package com.anodiam.StudentMasterData.serviceRepository.user.user;

import com.anodiam.StudentMasterData.model.User;

import java.util.Optional;

abstract class UserServiceImpl implements UserService {

    @Override
    public Optional<User> findByUsername(String username) {
        return new UserServiceDal().findByUsername(username);
    }
}
