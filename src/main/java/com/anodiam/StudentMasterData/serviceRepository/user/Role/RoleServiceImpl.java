package com.anodiam.StudentMasterData.serviceRepository.user.Role;

import com.anodiam.StudentMasterData.model.Role;

import java.util.Optional;

abstract class RoleServiceImpl implements RoleService {

    @Override
    public Optional<Role> findByRoleName(String roleName) {
        return new RoleServiceDal().findByRoleName(roleName);
    }
}
