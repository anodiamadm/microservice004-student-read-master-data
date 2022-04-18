package com.anodiam.StudentMasterData.serviceRepository.user.Permission;

import com.anodiam.StudentMasterData.model.Permission;

public interface PermissionService {
    Permission findByPermissionName(String permissionName);
}
