package com.anodiam.StudentMasterData.serviceRepository.userProfile.Permission;

import com.anodiam.StudentMasterData.model.Permission;

abstract class PermissionServiceImpl implements PermissionService {

    @Override
    public Permission findByPermissionName(String permissionName) {
        return new PermissionServiceDal().findByPermissionName(permissionName);
    }
}
