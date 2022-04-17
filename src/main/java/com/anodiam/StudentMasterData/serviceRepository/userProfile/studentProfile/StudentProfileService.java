package com.anodiam.StudentMasterData.serviceRepository.userProfile.studentProfile;

import com.anodiam.StudentMasterData.model.StudentProfile;
import com.anodiam.StudentMasterData.model.User;
import com.anodiam.StudentMasterData.model.common.MessageResponse;

import java.math.BigInteger;
import java.util.Optional;

public interface StudentProfileService {

    Optional<StudentProfile> findByUser(User user);
    StudentProfile save(StudentProfile studentProfile);
    MessageResponse removeOne(BigInteger studentProfileId);
}
