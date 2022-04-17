package com.anodiam.StudentMasterData.serviceRepository.userProfile.Role;

import com.anodiam.StudentMasterData.model.Role;

abstract class RoleServiceImpl implements RoleService {

    @Override
    public Role findByRoleName(String roleName) {
        return new RoleServiceDal().findByRoleName(roleName);
    }
}
