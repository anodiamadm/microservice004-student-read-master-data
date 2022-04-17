package com.anodiam.StudentMasterData.serviceRepository.userProfile.user;

import com.anodiam.StudentMasterData.model.User;
import com.anodiam.StudentMasterData.model.common.MessageResponse;
import com.anodiam.StudentMasterData.model.common.ResponseCode;
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

    @Override
    public User save(User user) {
        try {
            User userToSave = userRepository.save(user);
            userToSave.setMessageResponse(new MessageResponse(ResponseCode.SUCCESS.getID(), "User Saved Successfully!"));
            return userToSave;
        } catch (Exception exception) {
            exception.printStackTrace();
            user.setMessageResponse(new MessageResponse(ResponseCode.FAILURE.getID(), exception.getMessage()));
            return user;
        }
    }

    public User GetSingleUser()
    {
        try
        {
             return userRepository.findAll().get(0);
        } catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
    }

}
