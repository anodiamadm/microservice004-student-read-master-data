package com.anodiam.StudentMasterData.serviceRepository.user.Role;

import com.anodiam.StudentMasterData.model.Role;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findByRoleName(String roleName);
}
