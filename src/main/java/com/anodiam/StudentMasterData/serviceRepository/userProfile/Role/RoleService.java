package com.anodiam.StudentMasterData.serviceRepository.userProfile.Role;

import com.anodiam.StudentMasterData.model.Role;

public interface RoleService {
    Role findByRoleName(String roleName);
}
