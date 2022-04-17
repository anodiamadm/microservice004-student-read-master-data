package com.anodiam.StudentMasterData.serviceRepository.userProfile.Role;

import com.anodiam.StudentMasterData.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(String roleName);
}
