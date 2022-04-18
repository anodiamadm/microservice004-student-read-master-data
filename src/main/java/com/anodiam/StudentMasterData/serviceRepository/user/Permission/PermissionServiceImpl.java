package com.anodiam.StudentMasterData.serviceRepository.user.Permission;

import com.anodiam.StudentMasterData.model.Permission;

abstract class PermissionServiceImpl implements PermissionService {

    @Override
    public Permission findByPermissionName(String permissionName) {
        return new PermissionServiceDal().findByPermissionName(permissionName);
    }
}
