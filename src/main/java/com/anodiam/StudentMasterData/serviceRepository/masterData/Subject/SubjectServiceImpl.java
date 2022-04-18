package com.anodiam.StudentMasterData.serviceRepository.masterData.Subject;

import com.anodiam.StudentMasterData.model.masterData.Subject;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

abstract class SubjectServiceImpl implements SubjectService {

    @Override
    public List<Subject> findAll() {
        return new SubjectServiceDal().findAll();
    }

    @Override
    public Optional<Subject> findById(BigInteger subjectId) {
        return new SubjectServiceDal().findById(subjectId);
    }
}
