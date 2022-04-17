package com.anodiam.StudentMasterData.serviceRepository.userProfile.user;

import com.anodiam.StudentMasterData.model.User;

import java.util.Optional;

abstract class UserServiceImpl implements UserService {

    @Override
    public Optional<User> findByUsername(String username) {
        return new UserServiceDal().findByUsername(username);
    }

    @Override
    public User save(User user) {
        return new UserServiceDal().save(user);
    }

    @Override
    public User GetSingleUser() {
        return new UserServiceDal().GetSingleUser();
    }
}
