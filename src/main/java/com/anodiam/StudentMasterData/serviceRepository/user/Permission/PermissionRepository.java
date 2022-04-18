package com.anodiam.StudentMasterData.serviceRepository.user.Permission;

import com.anodiam.StudentMasterData.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
    Permission findByPermissionName(String permissionName);
}
