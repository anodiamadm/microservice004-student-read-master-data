package com.anodiam.StudentMasterData.serviceRepository.user.Role;

import com.anodiam.StudentMasterData.model.Role;

public interface RoleService {
    Role findByRoleName(String roleName);
}
