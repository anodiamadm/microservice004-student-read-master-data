package com.anodiam.StudentMasterData.serviceRepository.user.user;

import com.anodiam.StudentMasterData.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class UserServiceDal extends UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

    public UserServiceDal(){}

    @Override
    public Optional<User> findByUsername(String username) {
        try {
            Optional<User> optionalUser = userRepository.findByUsername(username);
            if(optionalUser.isPresent()) {
                return optionalUser;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
