package com.anodiam.StudentMasterData.serviceRepository.user.Role;

import com.anodiam.StudentMasterData.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class RoleServiceDal extends RoleServiceImpl {

    @Autowired
    private RoleRepository roleRepository;

    public RoleServiceDal(){}

    @Override
    public Role findByRoleName(String roleName) {
        try {
            Role role = roleRepository.findByRoleName(roleName);
            return role;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
