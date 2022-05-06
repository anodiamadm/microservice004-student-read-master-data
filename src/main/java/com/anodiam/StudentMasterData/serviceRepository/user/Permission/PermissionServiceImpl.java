package com.anodiam.StudentMasterData.serviceRepository.user.Permission;

import com.anodiam.StudentMasterData.model.Permission;

import java.util.Optional;

abstract class PermissionServiceImpl implements PermissionService {

    @Override
    public Optional<Permission> findByPermissionName(String permissionName) {
        return new PermissionServiceDal().findByPermissionName(permissionName);
    }
}
