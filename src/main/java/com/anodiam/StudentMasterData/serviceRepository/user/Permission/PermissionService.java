package com.anodiam.StudentMasterData.serviceRepository.user.Permission;

import com.anodiam.StudentMasterData.model.Permission;

import java.util.Optional;

public interface PermissionService {
    Optional<Permission> findByPermissionName(String permissionName);
}
