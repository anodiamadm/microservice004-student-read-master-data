package com.anodiam.StudentMasterData.serviceRepository.user.Role;

import com.anodiam.StudentMasterData.model.Role;
import com.anodiam.StudentMasterData.model.common.MessageResponse;
import com.anodiam.StudentMasterData.model.common.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class RoleServiceDal extends RoleServiceImpl {

    @Autowired
    private RoleRepository roleRepository;

    public RoleServiceDal(){}

    @Override
    public Optional<Role> findByRoleName(String roleName) {
        Role roleReturned = new Role();
        try {
            Optional<Role> optionalRole = roleRepository.findByRoleName(roleName);
            if(optionalRole.isPresent()) {
                roleReturned = optionalRole.get();
                roleReturned.setMessageResponse(new
                        MessageResponse(ResponseCode.ROLE_NAME_EXISTS.getID(),
                        ResponseCode.ROLE_NAME_EXISTS.getMessage()
                                + roleReturned.getRoleName()));
            } else {
                roleReturned.setMessageResponse(new
                        MessageResponse(ResponseCode.ROLE_NAME_INVALID.getID(),
                        ResponseCode.ROLE_NAME_INVALID.getMessage()
                                + roleReturned.getRoleName()));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            roleReturned.setMessageResponse(new MessageResponse(ResponseCode.FAILURE.getID(),
                    ResponseCode.FAILURE.getMessage() + exception.getMessage()));
        }
        return Optional.of(roleReturned);
    }
}
