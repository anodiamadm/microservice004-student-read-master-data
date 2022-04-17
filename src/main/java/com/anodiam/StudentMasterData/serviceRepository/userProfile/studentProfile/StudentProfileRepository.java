package com.anodiam.StudentMasterData.serviceRepository.userProfile.studentProfile;

import com.anodiam.StudentMasterData.model.StudentProfile;
import com.anodiam.StudentMasterData.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface StudentProfileRepository extends JpaRepository<StudentProfile, BigInteger> {
    Optional<StudentProfile> findByUser(User user);
}
