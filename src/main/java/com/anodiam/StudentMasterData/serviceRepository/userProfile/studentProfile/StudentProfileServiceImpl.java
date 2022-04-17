package com.anodiam.StudentMasterData.serviceRepository.userProfile.studentProfile;

import com.anodiam.StudentMasterData.model.StudentProfile;
import com.anodiam.StudentMasterData.model.User;
import com.anodiam.StudentMasterData.model.common.MessageResponse;

import java.math.BigInteger;
import java.util.Optional;

abstract class StudentProfileServiceImpl implements StudentProfileService {

    @Override
    public Optional<StudentProfile> findByUser(User user){
        return new StudentProfileServiceDal().findByUser(user);
    }

    @Override
    public StudentProfile save(StudentProfile studentProfile) {
        return new StudentProfileServiceDal().save(studentProfile);
    }

    @Override
    public MessageResponse removeOne(BigInteger studentProfileId) {
        return new StudentProfileServiceDal().removeOne(studentProfileId);
    }
}
