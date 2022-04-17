package com.anodiam.StudentMasterData.serviceRepository.userProfile.Permission;

import com.anodiam.StudentMasterData.model.Permission;

public interface PermissionService {
    Permission findByPermissionName(String permissionName);
}
